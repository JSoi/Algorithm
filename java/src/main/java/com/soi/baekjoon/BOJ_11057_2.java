package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_11057_2 {
    private static final int MOD = 10_007;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n + 1][10];
        for (int[] row : dp) Arrays.fill(row, -1);
        int answer = 0;
        for (int i = 0; i <= 9; i++) {
            answer = (answer + count(n, i)) % MOD;
        }
        System.out.println(answer);
    }

    static int count(int length, int lastDigit) {
        if (length == 1) return 1;
        if (dp[length][lastDigit] != -1) return dp[length][lastDigit];
        int total = 0;
        for (int i = 0; i <= lastDigit; i++) {
            total = (total + count(length - 1, i)) % MOD;
        }
        return dp[length][lastDigit] = total;
    }
}
