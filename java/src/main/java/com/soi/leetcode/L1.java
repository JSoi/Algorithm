package com.soi.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class L1 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new L1().twoSum(new int[]{3, 2, 4}, 6)));
    }

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    public int[] twoSum2(int[] nums, int target) {
        List<int[]> ints = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            ints.add(new int[]{i, num});
        }
        ints.sort(Comparator.comparingInt(a -> a[1]));
        int left = 0;
        int right = 1;
        int leftV = ints.get(left)[1];
        int rightV = ints.get(right)[1];
        while (leftV + rightV != target) {
            if (leftV + rightV > target) {
                left++;
                right = left + 1;
            } else {
                right++;
                if (right >= ints.size()) {
                    left++;
                    right = left + 1;
                }
            }
            leftV = ints.get(left)[1];
            rightV = ints.get(right)[1];
        }
        return new int[]{ints.get(left)[0], ints.get(right)[0]};
    }
}
