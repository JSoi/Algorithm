package com.soi.baekjoon;

import java.util.Scanner;

public class BOJ_1720 {
    public static void main(String[] args) {
        int N = Integer.parseInt(new Scanner(System.in).nextLine());
        int[] dp = new int[31];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= 30; i++) {
            dp[i] = dp[i - 1] + 2 * dp[i - 2];
        }
        int symmetricCount;
        if (N % 2 == 0) {
            symmetricCount = dp[N / 2] + dp[N / 2 - 1] * 2;
        } else {
            symmetricCount = dp[(N - 1) / 2];
        }
        System.out.println((dp[N] + symmetricCount) / 2);
    }
}
