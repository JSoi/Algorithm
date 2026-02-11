package com.soi.leetcode;

public class LC_189 {
    public void rotate(int[] nums, int k) {
        int rotate = k % nums.length;
        int[] rArr = new int[nums.length];
        int[] answer = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            answer[(i + rotate) % nums.length] = nums[i];
        }
        System.arraycopy(answer, 0, nums, 0, nums.length);
    }
}
