package com.soi.leetcode;

import java.util.Arrays;

public class LC_jump_game_ii {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == Integer.MAX_VALUE)
                continue;
            int jump = nums[i];
            for (int j = i + 1; j < Math.min(n, i + jump + 1); j++) {
                dp[j] = Math.min(dp[i] + 1, dp[j]);
            }
        }
        return dp[n - 1];
    }
}
