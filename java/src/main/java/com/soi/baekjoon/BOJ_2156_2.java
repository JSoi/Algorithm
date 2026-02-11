package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2156_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] cost = new int[n + 1];
        int[][] dp = new int[n + 1][2];
        for (int i = 1; i < n + 1; i++) {
            cost[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 1; i <= Math.min(n, 2); i++) {
            dp[i][0] = cost[i - 1];
            dp[i][1] = cost[i] + cost[i - 1];
        }
        if (n <= 2) {
            System.out.println(Math.max(dp[n][0], dp[n][1]));
            return;
        }
        for (int i = 3; i <= n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = Math.max(dp[i - 2][0] + cost[i] + cost[i - 1], dp[i - 2][1] + cost[i]);
        }
        System.out.println(Math.max(dp[n][0], dp[n][1]));
    }
}
