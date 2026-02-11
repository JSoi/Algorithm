package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class BOJ_17471 {
    private static int[] population;
    private static int n, answer;
    private static boolean[][] conn;
    private static int[] group;

    public static void main(String[] args) throws IOException {
        // 먼저 나눔
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        population = new int[n + 1];
        conn = new boolean[n + 1][n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            population[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int k = Integer.parseInt(st.nextToken());
            for (int j = 0; j < k; j++) {
                int b = Integer.parseInt(st.nextToken());
                conn[i][b] = conn[b][i] = true;
            }
        }
        answer = Integer.MAX_VALUE;
        group = new int[n + 1];
        group[1] = 1;
        go(2);
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    private static void go(int from) {
//        System.out.println(Arrays.toString(group));
        if (from > n) {
            if (isValidGrouping(1) && isValidGrouping(2)) {
                answer = Math.min(answer, calculateDiff());
            }
            return;
        }
        group[from] = 1;
        go(from + 1);
        group[from] = 2;
        go(from + 1);
    }

    private static boolean isValidGrouping(int groupType) {
        boolean[] v = new boolean[n + 1];
        int groupStart = IntStream.range(1, n + 1)
                .filter(i -> group[i] == groupType).findAny().orElse(0);

        if (groupStart == 0) {
            return false;
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(groupStart);
        v[groupStart] = true;

        while (!stack.isEmpty()) {
            int curr = stack.pop();
            for (int i = 1; i <= n; i++) {
                if (v[i] || !conn[curr][i] || group[i] != groupType) {
                    continue;
                }
                v[i] = true;
                stack.push(i);
            }
        }
        for (int i = 1; i <= n; i++) {
            if (group[i] == 0 || (group[i] == groupType && !v[i])) {
                return false;
            }
        }
        return true;
    }

    private static int calculateDiff() {
        int oneSum = 0;
        int twoSum = 0;
        for (int i = 1; i <= n; i++) {
            if (group[i] == 1) {
                oneSum += population[i];
            } else {
                twoSum += population[i];
            }
        }
        return Math.abs(oneSum - twoSum);
    }
}
