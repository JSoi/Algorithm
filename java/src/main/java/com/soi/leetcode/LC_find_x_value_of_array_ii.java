package com.soi.leetcode;

public class LC_find_x_value_of_array_ii {
    private int[] nums;
    private int[][] dp, cumulativeCount;
    private int n, k;

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        this.nums = nums;
        this.n = nums.length;
        this.k = k;
        this.dp = new int[n][k];
        this.cumulativeCount = new int[n][k];
        //init
        dp[n - 1][nums[n - 1] % k] = cumulativeCount[n - 1][nums[n - 1] % k] = 1;
        for (int i = n - 2; i >= 0; i--) {
            int rm = nums[i] % k;
            dp[i][rm] = 1;
            for (int kk = 0; kk < k; kk++) {
                int remainder = (rm * kk) % k;
                dp[i][remainder] += dp[i + 1][kk];
            }
            for (int kk = 0; kk < k; kk++) {
                cumulativeCount[i][kk] = dp[i][kk] + cumulativeCount[i + 1][kk];
            }
        }
        // compute
        int[] answer = new int[queries.length];
        int aIdx = 0;
        for (int[] q : queries) {
            answer[aIdx++] = query(q[0], q[1], q[2], q[3]);
        }
        return answer;
    }

    private int query(int idx, int value, int start, int x) {
        if (idx < start) {
            return cumulativeCount[start][x];
        }
        int rm = value % k;
        int count = 0;
        for (int kk = 0; kk < k; kk++) {
            int remainder = (rm * kk) % k;
            if (remainder == x) {
                count += dp[idx][kk];
            }
        }
        return count;
    }
}
