package com.soi.leetcode;

public class LC_product_of_array_except_self {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        boolean[] isZero = new boolean[len];
        int zeroCount = 0;
        int product = 1;
        for (int i = 0; i < len; i++) {
            int n = nums[i];
            if (n == 0) {
                zeroCount++;
                isZero[i] = true;
            } else {
                product *= n;
            }
        }
        int[] answer = new int[len];
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                answer[i] = zeroCount > 1 ? 0 : product;
            } else {
                answer[i] = zeroCount > 0 ? 0 : product / nums[i];
            }
        }
        return answer;
    }
}
