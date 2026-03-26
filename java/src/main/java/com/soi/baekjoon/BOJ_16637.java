package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_16637 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String original = br.readLine();
        opCount = n / 2;
        nums = new long[opCount+1];
        operators = new char[opCount];
        for (int i = 0; i < original.length(); i++) {
            if (i % 2 == 0) { // num
                nums[i / 2] = original.charAt(i) - '0';
            } else {
                operators[i / 2] = original.charAt(i);
            }
        }
        bondOperators(0, new boolean[opCount]);
        System.out.println(answer);
    }

    private static int opCount;
    private static long answer = Long.MIN_VALUE;
    private static long[] nums;
    private static char[] operators;

    private static long calculate(long a, long b, char op) {
        return switch (op) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            default -> throw new IllegalArgumentException();
        };
    }

    private static void bondOperators(int pos, boolean[] result) {
        if (pos >= opCount) {
            answer = Math.max(answer, calculateExpression(result));
            return;
        }
        result[pos] = true;
        bondOperators(pos + 2, result);
        result[pos] = false;
        bondOperators(pos + 1, result);
    }

    private static long calculateExpression(boolean[] isBond) {
        List<Long> values = new ArrayList<>();
        List<Character> opList = new ArrayList<>();

        int i = 0;
        while (i <= opCount) {
            if (i < opCount && isBond[i]) {
                values.add(calculate(nums[i], nums[i + 1], operators[i]));
                if (i + 1 < opCount) opList.add(operators[i + 1]);
                i += 2;
            } else {
                values.add(nums[i]);
                if (i < opCount) opList.add(operators[i]);
                i++;
            }
        }
        long res = values.get(0);
        for (int j = 0; j < opList.size(); j++) {
            res = calculate(res, values.get(j + 1), opList.get(j));
        }
        return res;
    }
}
