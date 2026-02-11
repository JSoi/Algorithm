package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2096 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][3];
        for (int i = 0; i < n; i++) {
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        }
        int[] answer = findNumber(board);
        System.out.println(answer[0] + " " + answer[1]);
    }

    private static int[] findNumber(int[][] board) {
        // bottom-up
        int[][][] score = new int[board.length][3][2];
        for (int k = 0; k < 3; k++) {
            score[board.length - 1][k][1] = score[board.length - 1][k][0] = board[board.length - 1][k];
        }
        for (int i = board.length - 2; i >= 0; i--) {
            int below = i + 1;
            // min
            score[i][0][0] = board[i][0] + Math.min(score[below][0][0], score[below][1][0]);
            score[i][1][0] = board[i][1] + Math.min(Math.min(score[below][0][0], score[below][1][0]), score[below][2][0]);
            score[i][2][0] = board[i][2] + Math.min(score[below][1][0], score[below][2][0]);

            // max
            score[i][0][1] = board[i][0] + Math.max(score[below][0][1], score[below][1][1]);
            score[i][1][1] = board[i][1] + Math.max(Math.max(score[below][0][1], score[below][1][1]), score[below][2][1]);
            score[i][2][1] = board[i][2] + Math.max(score[below][1][1], score[below][2][1]);
        }
        return new int[]{Math.max(score[0][0][1], Math.max(score[0][1][1], score[0][2][1])), Math.min(score[0][0][0], Math.min(score[0][1][0], score[0][2][0]))};
    }
}
