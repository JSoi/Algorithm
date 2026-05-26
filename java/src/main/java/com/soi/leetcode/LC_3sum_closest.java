package com.soi.leetcode;

import java.util.Arrays;

public class LC_3sum_closest {
    public static void main(String[] args) {
        int sum = new Solution().threeSumClosest(new int[]{-1, 2, 1, -4}, 1);
        System.out.println(sum);
    }

    private static class Solution {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int sum = 0;
            int diff = Integer.MAX_VALUE;
            int len = nums.length;
            for (int i = 0; i < len - 2; i++) {
                int j = i + 1;
                int k = len - 1;
                while (j < k) {
                    int s = nums[i] + nums[j] + nums[k];
                    int d = Math.abs(target - s);
                    if (d == 0) return s;
                    if (d < diff) {
                        sum = s;
                        diff = d;
                    }
                    if (s < target) j++;
                    else k--;
                }
            }
            return sum;
        }
        // -4 -1 1 2
    }
}
