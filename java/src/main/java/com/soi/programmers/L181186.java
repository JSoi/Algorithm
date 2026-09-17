package com.soi.programmers;

public class L181186 {
    private static final int MOD = 1_000_000_007;

    public int solution(int n) {
        int size = Math.max(n, 6) + 1;
        long[] dp = new long[size];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 3;
        dp[3] = 10;
        dp[4] = 23;
        dp[5] = 62;
        if (n <= 5) {
            return (int) dp[n];
        }
        for (int i = 6; i <= n; i++) {
            long val = dp[i - 1] + (2L * dp[i - 2]) % MOD + (6L * dp[i - 3]) % MOD + dp[i - 4] - dp[i - 6];
            dp[i] = (val % MOD + MOD) % MOD;
        }
        return (int) dp[n];
    }
}
