package com.soi.leetcode;

import java.util.Arrays;

public class LC_jump_game_v {
    public static void main(String[] args) {
        LC_jump_game_v solution = new LC_jump_game_v();
        int result = solution.maxJumps(new int[]{7, 6, 5, 4, 3, 2, 1}, 1);
        System.out.println(result); // Output: 4
    }

    int n, maxD;
    int[] arr, dp;

    public int maxJumps(int[] arr, int d) {
        n = arr.length;
        this.arr = arr;
        maxD = d;
        dp = new int[n];
        Arrays.fill(dp, -1);
        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, find(i));
        }
        return answer;
    }

    private int find(int i) {
        if (dp[i] != -1) {
            return dp[i];
        }
        dp[i] = 1;
        int l, r;
        for (int j = 1; j <= maxD && i - j >= 0; j++) {
            l = i - j;
            if (arr[i] <= arr[l]) break;
            if (arr[l] < arr[i]) {
                dp[i] = Math.max(dp[i], find(l) + 1);
            }
        }
        for (int j = 1; j <= maxD && i + j < n; j++) {
            r = i + j;
            if (arr[i] <= arr[r]) break;
            if (arr[r] < arr[i]) {
                dp[i] = Math.max(dp[i], find(r) + 1);
            }
        }
        return dp[i];
    }
}
