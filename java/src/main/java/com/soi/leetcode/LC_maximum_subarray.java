package com.soi.leetcode;

public class LC_maximum_subarray {
    public int maxSubArray(int[] nums) {
        int[][] dp = new int[nums.length][2];
        dp[0][0] = Integer.MIN_VALUE;
        dp[0][1] = nums[0];
        int max = nums[0];
        for(int i = 1 ; i < nums.length; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = Math.max(nums[i], nums[i] + dp[i-1][1]);
            max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
        }
        return max;
    }
}
