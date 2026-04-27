package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2098_2 {
    public static final int MAX = Integer.MAX_VALUE;
    public static int n;
    public static int[][] conn;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        conn = new int[n][n];
        for (int i = 0; i < n; i++) {
            conn[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int answer = MAX;
        for (int i = 0; i < n; i++) {
            answer = Math.min(answer, dp(i));
        }
        System.out.println(answer);
    }

    private static int dp(int start) {
        int[][] dp = new int[1 << n][n];
        for (int[] dd : dp) {
            Arrays.fill(dd, MAX);
        }
        dp[1 << start][start] = 0;
        for (int status = 0; status < (1 << n); status++) {
            for (int current = 0; current < n; current++) {
                if (dp[status][current] == MAX) continue;
                for (int next = 0; next < n; next++) {
                    if ((status & (1 << next)) != 0 || conn[current][next] == 0) {
                        continue;
                    }
                    int nextStatus = status | (1 << next);
                    int nextCost = dp[status][current] + conn[current][next];
                    dp[nextStatus][next] = Math.min(dp[nextStatus][next], nextCost);
                }
            }
        }
        int answer = MAX;
        for (int l = 0; l < n; l++) {
            if (dp[(1 << n) - 1][l] == MAX || conn[l][start] == 0) continue;
            answer = Math.min(answer, dp[(1 << n) - 1][l] + conn[l][start]);
        }
        return answer;
    }
}
