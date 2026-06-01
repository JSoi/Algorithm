package com.soi.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC_n_queens {
    public static void main(String[] args) {
        var s = new Solution();
        System.out.println(s.solveNQueens(4));
    }

    static class Solution {
        private boolean[] row, col, diag1, diag2;
        private int len;
        private List<List<String>> answer;

        public List<List<String>> solveNQueens(int n) {
            row = new boolean[n];
            col = new boolean[n];
            diag1 = new boolean[n * 2 - 1];
            diag2 = new boolean[n * 2 - 1];
            len = n;
            boolean[][] chess = new boolean[n][n];
            answer = new ArrayList<>();
            dp(0, 0, chess);
            return answer;
        }

        public void dp(int loc, int count, boolean[][] board) {
            if (count == len) {
                answer.add(toList(board));
                return;
            }
            if (loc >= len * len) return;

            int r = loc / len;
            int c = loc % len;
            int d1 = tod1Idx(r, c);
            int d2 = tod2Idx(r, c);
            if (row[r] || col[c] || diag1[d1] || diag2[d2]) {
                dp(loc + 1, count, board);
                return;
            }
            board[r][c] = row[r] = col[c] = diag1[d1] = diag2[d2] = true;
            dp(loc + 1, count + 1, board);
            board[r][c] = row[r] = col[c] = diag1[d1] = diag2[d2] = false;
            dp(loc + 1, count, board);
        }

        private int tod2Idx(int r, int c) {
            int rr = len - r - 1;
            int cc = c;
            return rr + cc;
        }

        private int tod1Idx(int r, int c) {
            return r + c;
        }

        private List<String> toList(boolean[][] board) {
            List<String> lineList = new ArrayList<>();
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
