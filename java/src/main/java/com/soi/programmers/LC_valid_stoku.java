package com.soi.programmers;

public class LC_valid_stoku {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][10];
        boolean[][] col = new boolean[9][10];
        boolean[][] block = new boolean[9][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int val = board[i][j] - '0';
                int blockPos = blockPosition(i * 9 + j);
                if (row[i][val] || col[j][val] || block[blockPos][val]) return false;
                row[i][val] = col[j][val] = block[blockPos][val] = true;
            }
        }
        return true;
    }

    private int blockPosition(int idx) {
        int r = idx / 9;
        int c = idx % 9;
        return (r / 3) * 3 + (c / 3);
    }
}
