package com.soi.leetcode;

public class LC_interleaving_string {
    public static void main(String[] args) {
        boolean result = new LC_interleaving_string().isInterleave("aaa", "bbb", "bbbbbb");
        System.out.println(result);
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        int l1 = s1.length();
        int l2 = s2.length();
        if (l1 + l2 != s3.length()) return false;
        boolean[][] dp = new boolean[l1 + 1][l2 + 1];
        dp[0][0] = true; // non
        for (int i = 1; i <= l1; i++) {
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }
        for (int j = 1; j <= l2; j++) {
            dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                int p3 = i + j - 1;
                if (s1.charAt(i - 1) == s3.charAt(p3)) {
                    dp[i][j] |= dp[i - 1][j];
                }
                if (s2.charAt(j - 1) == s3.charAt(p3)) {
                    dp[i][j] |= dp[i][j - 1];
                }
            }
        }
        return dp[l1][l2];
    }
}
