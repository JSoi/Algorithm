package com.soi.baekjoon;

import java.util.Scanner;

public class BOJ_5582 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String a = scan.nextLine();
        String b = scan.nextLine();
        int[][] dp = new int[a.length() + 1][b.length() + 1];
        int answer = 0;
        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                if (a.charAt(i - 1) != b.charAt(j - 1)) continue;
                dp[i][j] = dp[i - 1][j - 1] + 1;
                answer = Math.max(answer, dp[i][j]);
            }
        }
        System.out.println(answer);
    }
}
