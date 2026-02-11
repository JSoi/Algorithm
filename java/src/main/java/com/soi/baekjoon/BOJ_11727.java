package com.soi.baekjoon;


import java.util.Scanner;

public class BOJ_11727 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        if (N <= 2) {
            System.out.println(N == 1 ? 1 : 3);
            return;
        }
        int[] dp = new int[N + 1];
        dp[1] = 1;
        dp[2] = 3;
        for (int i = 3; i <= N; i++) {
            dp[i] = (2 * dp[i - 2] + dp[i - 1]) % 10007;
        }
        System.out.println(dp[N]);
    }
}
