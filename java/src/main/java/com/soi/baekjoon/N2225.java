package com.soi.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class N2225 {
    private static final long DIV = 1_000_000_000;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        long[][] dp = new long[n + 1][k + 1]; // idx = sum
        for (int i = 1; i <= n; i++) {
            dp[i][1] = 1;
        }
        Arrays.fill(dp[0], 1);
        dp[0][0] = 0;
        // 초기 K개 설정
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                for (int jj = 0; jj <= i; jj++) {
                    dp[i][j] = (dp[i][j] + (dp[jj][j - 1] * dp[i - jj][1])) % DIV;
                }
            }
        }
        System.out.println(dp[n][k]);
    }
}
