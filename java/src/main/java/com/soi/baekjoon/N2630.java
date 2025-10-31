package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * <a href = "https://www.acmicpc.net/problem/2630">색종이 만들기</a>
 */
public class N2630 {
    private static int whiteCount = 0;
    private static int blueCount = 0;
    private static int n;
    private static int[][] board;

    public static void main(String[] args) throws IOException {
        init();
        divide(0, 0, n);
        System.out.println(whiteCount);
        System.out.println(blueCount);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(tok.nextToken());
            }
        }
//        System.out.println(Arrays.deepToString(board));

    }

    private static void divide(int r, int c, int size) {
        if (size == 1) {
            if (board[r][c] == 1) {
                blueCount++;
            } else {
                whiteCount++;
            }
            return;
        }
        if (isIdentical(r, c, size)) {
            if (board[r][c] == 1) {
                blueCount++;
            } else {
                whiteCount++;
            }
            return;
        }
        int nextSize = size / 2;
        for (int i = 0; i < 4; i++) {
            divide(r + nextSize * (i / 2), c + nextSize * (i % 2), nextSize);
        }
    }

    private static boolean isIdentical(int r, int c, int size) {
        int color = board[r][c];
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (board[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}
