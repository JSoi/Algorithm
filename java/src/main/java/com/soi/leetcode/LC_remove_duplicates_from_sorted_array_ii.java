package com.soi.leetcode;

/**
 * <a href = "https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/">Remove Duplicates from Sorted Array II</a>
 */
public class LC_remove_duplicates_from_sorted_array_ii {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int idx = 0;
        for (int i = 0; i < n; i++) {
            int val = nums[i];
            nums[idx++] = val;
            int duplicate = 1;
            while (i + 1 < n && nums[i + 1] == val) {
                i++;
                duplicate++;
                if (duplicate <= 2) {
                    nums[idx++] = val;
                }
            }
        }
        return idx;
    }
}
