package com.soi.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_permutations_ii {
    private int n;
    private int[] nums;
    private List<List<Integer>> answer;

    public List<List<Integer>> permuteUnique(int[] nums) {
        this.n = nums.length;
        this.nums = nums;
        this.answer = new ArrayList<>();
        Arrays.sort(nums);
        permutation(0, new boolean[n], new int[n]);
        return this.answer;
    }

    private void permutation(int pos, boolean[] used, int[] result) {
        if (pos == n) {
            answer.add(new ArrayList<>(Arrays.stream(result).boxed().toList()));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (used[i] || (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]))
                continue;
            used[i] = true;
            result[pos] = nums[i];
            permutation(pos + 1, used, result);
            used[i] = false;
        }
    }
}
