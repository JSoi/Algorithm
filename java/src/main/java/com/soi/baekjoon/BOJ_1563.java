package com.soi.baekjoon;

import java.util.Scanner;

/**
 * <a href = "https://www.acmicpc.net/problem/1563">개근상</a>
 */
public class BOJ_1563 {
    private static final int MOD = 1_000_000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int day = sc.nextInt();
        sc.close();
        long[][][] dp = new long[day + 1][2][3];
        dp[0][0][0] = 1;
        for (int i = 1; i <= day; i++) {
            // 지각 0
            dp[i][0][0] = (dp[i - 1][0][0] + dp[i - 1][0][1] + dp[i - 1][0][2]) % MOD;
            dp[i][0][1] = dp[i - 1][0][0]; // 결석 1
            dp[i][0][2] = dp[i - 1][0][1]; // 결석 2

            // 지각 1
            dp[i][1][0] = (dp[i - 1][0][0] + dp[i - 1][0][1] + dp[i - 1][0][2] + dp[i - 1][1][0] + dp[i - 1][1][1] + dp[i - 1][1][2]) % MOD;
            dp[i][1][1] = dp[i - 1][1][0]; // 지각 1 + 결석 1
            dp[i][1][2] = dp[i - 1][1][1]; // 지각 1 + 결석 2
        }

        long answer = 0;
        for (long[] d : dp[day]) {
            for (long val : d) {
                answer = (answer + val) % MOD;
            }
        }
        System.out.println(answer);
    }
}
