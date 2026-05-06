package com.soi.leetcode;

import java.util.Arrays;

public class LC_sudoku_solver {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        new LC_sudoku_solver().solveSudoku(board);
    }

    private boolean[][] rowStatus;
    private boolean[][] colStatus;
    private boolean[][] blockStatus;
    private char[][] answer = new char[9][9];
    private boolean solved;

    public void solveSudoku(char[][] board) {
        rowStatus = new boolean[9][10];
        colStatus = new boolean[9][10];
        blockStatus = new boolean[9][10];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                int val = board[i][j] - '0';
                rowStatus[i][val] = colStatus[j][val] = blockStatus[blockIdx(i, j)][val] = true;
            }
        }
        backTracking(0, board);
        System.out.println(Arrays.deepToString(board));
    }

    private boolean backTracking(int blockIdx, char[][] board) {
        if (blockIdx == 81) {
            return true;
        }
        int r = blockIdx / 9;
        int c = blockIdx % 9;
        int b = blockIdx(r, c);
        if (board[r][c] != '.') {
            return backTracking(blockIdx + 1, board);
        }
        for (int i = 1; i <= 9; i++) {
            if (rowStatus[r][i] || colStatus[c][i] || blockStatus[b][i]) continue;
            rowStatus[r][i] = colStatus[c][i] = blockStatus[b][i] = true;
            board[r][c] = (char) (i + '0');
            if (backTracking(blockIdx + 1, board)) return true;
            rowStatus[r][i] = colStatus[c][i] = blockStatus[b][i] = false;
            board[r][c] = '.';
        }
        return false;
    }

    private int blockIdx(int rr, int cc) {
        return (rr / 3) * 3 + (cc / 3);
    }
}
