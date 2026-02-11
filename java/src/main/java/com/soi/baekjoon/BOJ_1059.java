package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1059 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        buf.readLine();
        int[] array = Arrays.stream(buf.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        int target = Integer.parseInt(buf.readLine());
        System.out.println(solution(array, target));
    }

    private static int solution(int[] array, int target) {
        int start = 0;
        for (int i : array) {
            if (target >= start && target <= i) {
                if (target == start || target == i) {
                    return 0;
                }
                return getNumber(start + 1, i - 1, target);
            }
            start = i;
        }
        return 0;
    }

    private static int getNumber(int startInclusive, int endInclusive, int target) {
        return (Math.max(target - startInclusive, 0)) * (Math.max(endInclusive - target, 0)) + (target - startInclusive) + (endInclusive - target);
    }
}
