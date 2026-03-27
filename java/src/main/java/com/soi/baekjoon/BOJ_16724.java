package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_16724 {
    private static final int[][] move = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static char[][] board;
    private static int[][] typeArr;
    private static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int r = Integer.parseInt(line[0]);
        int c = Integer.parseInt(line[1]);

        board = new char[r][c];
        for (int i = 0; i < r; i++) {
            board[i] = br.readLine().toCharArray();
        }
        typeArr = new int[r][c];
        for (int[] ta : typeArr) {
            Arrays.fill(ta, -1);
        }
        int type = 0;
        visit = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (visit[i][j]) {
                    continue;
                }
                int posType = dfs(i, j, type);
                if (posType == type) {
                    type++;
                }
            }
        }
//        for (int[] ta : typeArr) {
//            System.out.println(Arrays.toString(ta));
//        }
        System.out.println(type);
    }

    private static int dfs(int rr, int cc, int tt) {
        if (typeArr[rr][cc] != -1) {
            return typeArr[rr][cc];
        }
        if (visit[rr][cc]) {
            return typeArr[rr][cc] = tt;
        }
        visit[rr][cc] = true;
        int nR = rr + move[toIdx(board[rr][cc])][0];
        int nC = cc + move[toIdx(board[rr][cc])][1];
        int subType = dfs(nR, nC, tt);
        return typeArr[rr][cc] = subType;
    }

    private static int toIdx(char ch) {
        return switch (ch) {
            case 'U' -> 0;
            case 'D' -> 1;
            case 'L' -> 2;
            case 'R' -> 3;
            default -> throw new IllegalStateException("Unexpected value: " + ch);
        };
    }
}
