package com.soi.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class N1509 {
    static final int MAX = 20_000;
    static boolean[][] palindrome;

    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();
        int n = input.length();
        palindrome = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            palindrome[i][i] = true;
            if (i == n - 1) continue;
            palindrome[i][i + 1] = input.charAt(i) == input.charAt(i + 1);
        }
        for (int i = 0; i < n - 1; i++) {
            if (input.charAt(i) == input.charAt(i + 1)) {
                palindrome[i][i + 1] = true;
            }
        }

        for (int len = 3; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                if (input.charAt(i) == input.charAt(j) && palindrome[i + 1][j - 1]) {
                    palindrome[i][j] = true;
                }
            }
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, MAX);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (palindrome[j][i - 1]) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        System.out.println(dp[n]);
    }

//    private static int dp(int start, int end) {
//        if (count[start][end] != MAX) {
//            return count[start][end];
//        }
//        if (palindrome[start][end]) {
//            return count[start][end] = 1;
//        }
//        int min = MAX;
//        for (int i = start; i < end; i++) {
//            min = Math.min(min, dp(start, i) + dp(i + 1, end));
//        }
//        return count[start][end] = min;
//    }
}
