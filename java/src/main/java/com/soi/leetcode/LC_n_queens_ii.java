package com.soi.leetcode;

import java.util.Arrays;

public class LC_n_queens_ii {
    public static void main(String[] args) {
        var s = new Solution();
        System.out.println(s.totalNQueens(4));
    }

    static class Solution {
        int answer = 0;
        int len;

        public int totalNQueens(int n) {
            int[] pos = new int[n];
            len = n;
            Arrays.fill(pos, -1);
            answer = 0;
            dp(0, pos);
            return answer;
        }

        private void dp(int row, int[] pos) {
            if (row == len) {
                answer++;
                return;
            }
            for (int col = 0; col < len; col++) {
                if (!canFill(row, col, pos)) {
                    continue;
                }
                pos[row] = col;
                dp(row + 1, pos);
                pos[row] = -1;
            }
        }

        private boolean canFill(int row, int col, int[] pos) {
            for (int r = 0; r < row; r++) {
                if (pos[r] == col || Math.abs(pos[r] - col) == Math.abs(r - row)) {
                    return false;
                }
            }
            return true;
        }
    }
}
