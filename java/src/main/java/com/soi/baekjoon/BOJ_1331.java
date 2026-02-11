package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1331 {
    static final int[][] movements = new int[][]{{1, 2}, {-1, 2}, {1, -2}, {-1, -2}, {2, 1}, {-2, 1}, {2, -1}, {-2, -1}};
    static boolean[][] chessBoard;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        chessBoard = new boolean[6][6];
        int[][] input = new int[36][2];
        for (int i = 0; i < 36; i++) {
            int[] position = toPosition(br.readLine());
            input[i][0] = position[0];
            input[i][1] = position[1];
        }
        chessBoard[input[0][0]][input[0][1]] = true;
        int currR = input[0][0];
        int currC = input[0][1];
        for (int c = 1; c < 36; c++) {
            int nextR = input[c][0];
            int nextC = input[c][1];
            if (!canMove(currR, currC, nextR, nextC)) {
                System.out.println("Invalid");
                return;
            }
            chessBoard[nextR][nextC] = true;
            currR = nextR;
            currC = nextC;
        }
        if (isKnightMove(currR, currC, input[0][0], input[0][1])) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }

    private static int[] toPosition(String pos) {
        int row = pos.charAt(1) - '1';
        int col = pos.charAt(0) - 'A';
        return new int[]{row, col};
    }

    private static boolean canMove(int r1, int c1, int r2, int c2) {
        if (chessBoard[r2][c2]) {
            return false;
        }
        return isKnightMove(r1, c1, r2, c2);
    }

    private static boolean isKnightMove(int r1, int c1, int r2, int c2) {
        for (int[] m : movements) {
            if (m[0] == r1 - r2 && m[1] == c1 - c2) {
                return true;
            }
        }
        return false;
    }
}
