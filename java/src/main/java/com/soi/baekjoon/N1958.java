package com.soi.baekjoon;

import java.util.Scanner;

public class N1958 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String A = scan.nextLine();
        String B = scan.nextLine();
        String C = scan.nextLine();
        int aLen = A.length();
        int bLen = B.length();
        int cLen = C.length();
        int[][][] dp = new int[aLen + 1][bLen + 1][cLen + 1];
        // dp[i][j][k] = dp[i-1][j-1][k-1] + 1;
        for (int i = 1; i <= aLen; i++) {
            for (int j = 1; j <= bLen; j++) {
                for (int k = 1; k <= cLen; k++) {
                    if (A.charAt(i - 1) == B.charAt(j - 1) && A.charAt(i - 1) == C.charAt(k - 1)) {
                        dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1;
                    } else {
                        dp[i][j][k] = Math.max(Math.max(dp[i - 1][j][k], dp[i][j - 1][k]), dp[i][j][k - 1]);
                    }
                }
            }
        }
        System.out.println(dp[aLen][bLen][cLen]);
    }
}
