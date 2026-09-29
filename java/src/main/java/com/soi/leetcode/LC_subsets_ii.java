package com.soi.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_subsets_ii {
    private int[] nums;
    private List<List<Integer>> result;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        result = new ArrayList<>();
        this.nums = nums;
        Arrays.sort(nums);
        backtrack(new ArrayList<>(), 0);
        return result;
    }

    private void backtrack(List<Integer> curr, int start) {
        result.add(new ArrayList<>(curr));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            curr.add(nums[i]);
            backtrack(curr, i + 1);
            curr.remove(curr.size() - 1);
        }
    }
}
