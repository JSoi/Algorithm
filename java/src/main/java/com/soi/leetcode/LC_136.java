package com.soi.leetcode;

public class LC_136 {
    public int singleNumber(int[] nums) {
        if (nums.length == 1) return nums[0];
        int num = 0;
        int none = -1;
        boolean[] visit = new boolean[nums.length];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (visit[i]) continue;
                if ((nums[i] ^ nums[j]) == 0) {
                    visit[i] = true;
                    visit[j] = true;
                }
            }
        }
        for (int i = 0; i < visit.length; i++) {
            if (!visit[i]) {
                return nums[i];
            }
        }
        return 0;
    }
}
