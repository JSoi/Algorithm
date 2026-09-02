package com.soi.leetcode;

public class LC_search_in_rotated_sorted_array_ii {
    public boolean search(int[] nums, int target) {
        for(int n : nums){
            if(target == n) return true;
        }
        return false;
    }
}
