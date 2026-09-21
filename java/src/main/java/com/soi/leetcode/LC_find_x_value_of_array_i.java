package com.soi.leetcode;

public class LC_find_x_value_of_array_i {
    public long[] resultArray(int[] nums, int k) {
        int n = nums.length;
        long[] answer = new long[k];
        long[][] dp = new long[n][k];
        dp[n - 1][nums[n - 1] % k]++;
        for (int i = n - 2; i >= 0; i--) {
            int rm = nums[i] % k;
            for (int kk = 0; kk < k; kk++) {
                int remainder = (rm * kk) % k;
                dp[i][remainder] += dp[i + 1][kk];
                answer[remainder] += dp[i + 1][kk];
            }
            dp[i][rm]++;
            answer[rm]++;
        }
        return answer;
    }
}
