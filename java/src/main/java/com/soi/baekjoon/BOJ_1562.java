package com.soi.baekjoon;

import java.util.Scanner;

public class BOJ_1562 {
    private static final long MOD = 1_000_000_000;

    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        long[][][] dp = new long[n][10][1 << 10];
        for (int i = 1; i <= 9; i++) {
            dp[0][i][1 << i] = 1;
        }
        for (int i = 0; i < n - 1; i++) {
            for (int num = 0; num < 10; num++) {
                for (int mask = 0; mask < (1 << 10); mask++) {
                    if (dp[i][num][mask] == 0) {
                        continue;
                    }
                    int minus = num - 1;
                    if (minus >= 0) {
                        int minusMask = (1 << minus) | mask;
                        dp[i + 1][minus][minusMask] += dp[i][num][mask];
                        dp[i + 1][minus][minusMask] %= MOD;
                    }
                    int plus = num + 1;
                    if (plus < 10) {
                        int plusMask = (1 << plus) | mask;
                        dp[i + 1][plus][plusMask] += dp[i][num][mask];
                        dp[i + 1][plus][plusMask] %= MOD;
                    }
                }
            }
        }
        long answer = 0;
        for (int i = 0; i < 10; i++) {
            answer = (answer + dp[n - 1][i][(1 << 10) - 1]) % MOD;
        }
        System.out.println(answer);
    }
}
