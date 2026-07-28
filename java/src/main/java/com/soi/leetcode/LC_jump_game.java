package com.soi.leetcode;

public class LC_jump_game {
    int[] nums;
    int n;

    public boolean canJump(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        boolean[] jump = new boolean[n];
        jump[0] = true;
        for (int i = 0; i < n; i++) {
            if (!jump[i]) continue;
            hop(jump, i);
        }
        return jump[n - 1];
    }

    private void hop(boolean[] jump, int idx) {
        for (int i = 1; i <= nums[idx] && i + idx < n; i++) {
            jump[idx + i] = true;
        }
    }
}
