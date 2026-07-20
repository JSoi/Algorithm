package com.soi.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_combination_sum_ii {
    private static int totalSum;
    private static int[] arr;
    private static List<List<Integer>> result;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        result = new ArrayList<>();
        Arrays.sort(candidates);
        arr = candidates;
        totalSum = target;
        comb(arr, totalSum, 0, new ArrayList<>());
        return result;
    }
    private static void comb(int[] candidates, int target, int start, List<Integer> current) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            if (candidates[i] > target) break;
            current.add(candidates[i]);
            comb(candidates, target - candidates[i], i + 1, current);
            current.removeLast();
        }
    }
}
