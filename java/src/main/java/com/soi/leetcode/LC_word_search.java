package com.soi.leetcode;

public class LC_word_search {
    private String word;
    private char[][] board;
    private int r, c, maxDepth;
    private static final int[][] move = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public boolean exist(char[][] board, String word) {
        r = board.length;
        c = board[0].length;
        this.maxDepth = word.length();
        this.board = board;
        this.word = word;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (dfs(i, j, 0))
                    return true;
            }
        }
        return false;
    }

    private boolean dfs(int rr, int cc, int idx) {
        if (idx == maxDepth)
            return true;
        if (!inRange(rr, cc) || board[rr][cc] != word.charAt(idx))
            return false;
        char temp = board[rr][cc];
        board[rr][cc] = 0;
        for (int[] m : move) {
            int nR = rr + m[0];
            int nC = cc + m[1];
            if (dfs(nR, nC, idx + 1))
                return true;
        }
        board[rr][cc] = temp;
        return false;
    }

    private boolean inRange(int rr, int cc) {
        return rr >= 0 && rr < r && cc >= 0 && cc < c;
    }
}
