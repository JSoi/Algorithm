package com.soi.leetcode;

public class LC_house_robber_iv {
    public int minCapability(int[] nums, int k) {
        int min = 1;
        int max = (int) 1e9;
        int n = nums.length;
        while (min < max) {
            int mid = (min + max) / 2;
            int count = aboveCount(nums, mid);
            if (count >= k) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }

    private int aboveCount(int[] nums, int val) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= val) {
                count++;
                i++;
            }
        }
        return count;
    }
}
