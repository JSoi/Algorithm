package com.soi.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_3sum {
    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(lists);
    }
    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> answer = new ArrayList();
            Arrays.sort(nums);
            // no duplicate
            int len = nums.length;
            for (int i = 0; i < len - 2; i++) {
                if (i > 0 && nums[i] == nums[i - 1])
                    continue;
                int j = i + 1;
                int k = len - 1;
                while (j < k) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum == 0) {
                        answer.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        j++;
                        k--;
                        while (j < k && nums[j] == nums[j - 1]) j++;
                        while (j < k && nums[k] == nums[k + 1]) k--;
                    } else if (sum < 0) {
                        j++;
                    } else {
                        k--;
                    }
                }
            }
            return answer;
        }
        // -4 -1 -1 0 1 2
    }
}
