package com.soi.baekjoon;

import java.util.Scanner;

public class BOJ_11726 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        final int div = 10007;
        int n = scan.nextInt();
        scan.close();
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % div;
        }
        System.out.println(dp[n]);
    }
}
