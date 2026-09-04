package com.soi.leetcode;

/**
 * <a href = "https://leetcode.com/problems/smallest-stable-index-i">3903. Smallest Stable Index I</a>
 */
public class LC_smallest_stable_index_i {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int min[] = new int[n];
        min[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            min[i] = Math.min(nums[i], min[i + 1]);
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            int stablity = max - min[i];
            if (stablity <= k) {
                return i;
            }
        }
        return -1;
    }
}
