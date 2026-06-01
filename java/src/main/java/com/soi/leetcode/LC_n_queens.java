package com.soi.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_n_queens {
    public static void main(String[] args) {
        var s = new Solution();
        System.out.println(s.solveNQueens(4));
    }

    static class Solution {
        private int len;
        private List<List<String>> answer;

        public List<List<String>> solveNQueens(int n) {
            int[] position = new int[n];
            len = n;
            Arrays.fill(position, -1);
            answer = new ArrayList<>();
            dp(0, position);
            return answer;
        }

        private void dp(int row, int[] position) {
            if (row == len) {
                answer.add(toList(position));
                return;
            }
            for (int c = 0; c < len; c++) {
                if (canFill(row, c, position)) {
                    position[row] = c;
                    dp(row + 1, position);
                    position[row] = -1;
                }
            }
        }

        private boolean canFill(int row, int col, int[] pos) {
            for (int r = 0; r < len; r++) {
                if (row == r || pos[r] == -1) continue;
                // 대각선의 위치
                int c = pos[r];
                if (c == col || (Math.abs(row - r) == Math.abs(c - col))) {
                    return false;
                }
            }
            return true;
        }

        private List<String> toList(int[] pos) {
            boolean[][] board = new boolean[len][len];
            for (int row = 0; row < len; row++) {
                for (int col = 0; col < len; col++) {
                    board[row][pos[row]] = true;
                }
            }
            ArrayList<String> lineList = new ArrayList<>();
            for (boolean[] b : board) {
                StringBuilder lineSb = new StringBuilder();
                for (boolean value : b) {
                    lineSb.append(value ? "Q" : ".");
                }
                lineList.add(lineSb.toString());
            }
            return lineList;
        }
    }
}
