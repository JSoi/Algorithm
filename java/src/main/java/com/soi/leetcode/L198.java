package com.soi.leetcode;

public class L198 {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0],nums[1]);
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];
        int answer = Math.max(dp[0], dp[1]);
        for (int i = 2; i < nums.length; i++) {
            int max = 0;
            for (int j = 0; j <= i - 2; j++) {
                max = Math.max(max, dp[j]);
            }
            dp[i] = max + nums[i];
            answer = Math.max(answer, dp[i]);
        }
        return answer;
    }
}
