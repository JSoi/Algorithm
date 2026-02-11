package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12100 {
    public final int[] fx = {-1, -1, 1, 1};
    public final int[] fy = {-1, -1, 1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(buf.readLine());
        int[][] board = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer token = new StringTokenizer(buf.readLine(), " ");
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(token.nextToken());
            }
        }

    }

    public static void moveLeft(int[][] board) {

    }

    public static void moveRight(int[][] board) {

    }

    public static void moveDown(int[][] board) {

    }

    public static void moveUp(int[][] board) {

    }

    public static int maxElement(int[][] array) {
        int max = -1;
        for (int[] ar : array) {
            for (int a : ar) {
                max = Math.max(max, a);
            }
        }
        return max;
    }

}
