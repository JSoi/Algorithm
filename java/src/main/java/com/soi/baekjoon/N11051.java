package com.soi.baekjoon;

import java.util.Scanner;

public class N11051 {
    static int[][] dp;
    static final int DIV = 10007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        dp = new int[n + 1][k + 1];
        System.out.println(comb(n, k) % DIV);
    }

    static int comb(int n, int r) {
        if (r == 0 || n == r) {
            return dp[n][r] = 1;
        }
        if (dp[n][r] == 0) {
            return dp[n][r] = (comb(n - 1, r - 1) % DIV + comb(n - 1, r) % DIV) % DIV;
        }
        return dp[n][r];
    }
}
