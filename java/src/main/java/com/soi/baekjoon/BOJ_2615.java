package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2615 {
    private static final int[][] board = new int[19][19];
    private static final boolean[][][] searched = new boolean[19][19][4];
    private static final int[][] dir = new int[][]{{1, 0}, {0, 1}, {1, 1}, {1, -1}};
    private static int ansR, ansC;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 19; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < 19; j++) {
                board[i][j] = Integer.parseInt(line[j]);
            }
        }
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (board[i][j] == 0) {
                    continue;
                }
                if (hasWon(i, j)) {
                    System.out.println(board[i][j]);
                    System.out.println((ansR + 1) + " " + (ansC + 1));
                    return;
                }
            }
        }
        System.out.println(0);
    }

    private static boolean hasWon(int r, int c) {
        int color = board[r][c];
        for (int d = 0; d < 4; d++) {
            if (searched[r][c][d]) {
                continue;
            }
            searched[r][c][d] = true;
            int len = length(r + dir[d][0], c + dir[d][1], color, 1, d);
            if (len == 5) {
                if (d < 3) {
                    ansR = r;
                    ansC = c;
                } else {
                    ansR = r + 4;
                    ansC = c - 4;
                }
                return true;
            }
        }
        return false;
    }

    private static int length(int r, int c, int color, int len, int d) {
        if (r < 0 || r >= 19 || c < 0 || c >= 19
                || board[r][c] != color
                || searched[r][c][d]) {
            return len;
        }
        searched[r][c][d] = true;
        return length(r + dir[d][0], c + dir[d][1], color, len + 1, d);
    }
}
