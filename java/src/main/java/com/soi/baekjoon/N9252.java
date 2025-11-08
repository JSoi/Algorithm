package com.soi.baekjoon;

import java.util.Scanner;

public class N9252 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.nextLine();
        String B = sc.nextLine();
        int aLen = A.length();
        int bLen = B.length();

        int[][] dp = new int[aLen + 1][bLen + 1];

        for (int i = 1; i <= aLen; i++) {
            for (int j = 1; j <= bLen; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println(dp[aLen][bLen]);

        StringBuilder lcsStr = new StringBuilder();
        int i = aLen, j = bLen;
        while (i > 0 && j > 0) {
            if (A.charAt(i - 1) == B.charAt(j - 1)) {
                lcsStr.insert(0,A.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        System.out.println(lcsStr);
    }
}
