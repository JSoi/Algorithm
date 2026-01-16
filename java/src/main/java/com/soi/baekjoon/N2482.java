package com.soi.baekjoon;

import java.util.Scanner;

public class N2482 {
    private static final int MOD = 1_000_000_003;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        // 5 2 5
        int withOne = solve(n - 3, k - 1);
        int withoutOne = solve(n - 1, k);
        System.out.println((withOne + withoutOne) % MOD);
    }
    static int solve(int len, int cnt) {
        if (cnt < 0 || len < 0) return 0;
        if (cnt == 0) return 1;
        if (len < 2 * cnt - 1) return 0;

        int[][] dp = new int[len + 1][cnt + 1];

        dp[0][0] = 1;
        dp[1][0] = 1;
        dp[1][1] = 1;

        for (int i = 2; i <= len; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= cnt; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i - 2][j - 1]) % MOD;
            }
        }
        return dp[len][cnt];
    }
}
