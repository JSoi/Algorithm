package com.soi.baekjoon;

import java.util.Scanner;

public class BOJ_1328 {
    private static final long MOD = 1_000_000_007L;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int L = sc.nextInt();
        int R = sc.nextInt();

        long[][][] dp = new long[N + 1][N + 1][N + 1];
        // dp[len][left][right]
        dp[1][1][1] = 1;

        for (int n = 2; n <= N; n++) {
            for (int l = 1; l <= n; l++) {
                for (int r = 1; r <= n; r++) {
                    long val = 0;
                    if (l > 1) val += dp[n - 1][l - 1][r];
                    if (r > 1) val += dp[n - 1][l][r - 1];
                    val += (n - 2) * dp[n - 1][l][r];
                    dp[n][l][r] = val % MOD;
                }
            }
        }
        System.out.println(dp[N][L][R] % MOD);
    }
}
