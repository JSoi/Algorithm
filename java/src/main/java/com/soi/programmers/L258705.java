package com.soi.programmers;

public class L258705 {
    private static final int DIV = 10007;

    public int solution(int n, int[] tops) {
        int[][] dp = new int[n][2];
        // init
        // 가운데 부분이 빠지는 경우 0
        dp[0][0] = 1;
        dp[0][1] = tops[0] == 0 ? 2 : 3;
        // dp
        for (int i = 1; i < n; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1]) % DIV;
            if (tops[i] == 1) {
                dp[i][1] = (2 * dp[i - 1][0] + 3 * dp[i - 1][1]) % DIV;
            } else {
                dp[i][1] = (dp[i - 1][0] + 2 * dp[i - 1][1]) % DIV;
            }
        }
        return (dp[n - 1][0] + dp[n - 1][1]) % DIV;
    }
}
