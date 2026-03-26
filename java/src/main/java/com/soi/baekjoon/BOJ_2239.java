package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_2239 {
    static int[][] board = new int[9][9];
    static List<int[]> blanks = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            String line = br.readLine();
            for (int j = 0; j < 9; j++) {
                board[i][j] = line.charAt(j) - '0';
                if (board[i][j] == 0) {
                    blanks.add(new int[]{i, j});
                }
            }
        }
        dfs(0);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(board[i][j]);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    private static boolean dfs(int depth) {
        if (depth == blanks.size()) {
            return true;
        }
        int[] pos = blanks.get(depth);
        int r = pos[0];
        int c = pos[1];

        int used = status(r, c);

        for (int num = 1; num <= 9; num++) {
            if ((used & (1 << num)) != 0) continue;
            board[r][c] = num;
            if (dfs(depth + 1)) return true;
            board[r][c] = 0;
        }
        return false;
    }

    private static int status(int r, int c) {
        int status = 0;
        for (int i = 0; i < 9; i++) {
            if (board[r][i] != 0) status |= 1 << board[r][i];
            if (board[i][c] != 0) status |= 1 << board[i][c];
        }
        int blockR = (r / 3) * 3;
        int blockC = (c / 3) * 3;
        for (int i = blockR; i < blockR + 3; i++) {
            for (int j = blockC; j < blockC + 3; j++) {
                if (board[i][j] != 0) status |= 1 << board[i][j];
            }
        }
        return status;
    }
}

