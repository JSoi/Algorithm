package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_12100 {
    private static int N;
    private static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        dfs(0, board);
        System.out.println(answer);
    }

    private static void dfs(int depth, int[][] board) {
        if (depth == 5) {
            int max = Arrays.stream(board).flatMapToInt(Arrays::stream).max().orElse(0);
            answer = Math.max(answer, max);
            return;
        }
        int[][] dBoard = moveDown(board);
        dfs(depth + 1, dBoard);
        int[][] uBoard = moveUp(board);
        dfs(depth + 1, uBoard);
        int[][] lBoard = moveLeft(board);
        dfs(depth + 1, lBoard);
        int[][] rBoard = moveRight(board);
        dfs(depth + 1, rBoard);
    }

    public static int[][] moveLeft(int[][] b) {
        int[][] board = getBoard(b);
        for (int rr = 0; rr < N; rr++) {
            ArrayDeque<Integer> rowQueue = new ArrayDeque<>();
            for (int cc = 0; cc < N; cc++) {
                if (board[rr][cc] == 0) continue;
                rowQueue.addLast(board[rr][cc]);
                board[rr][cc] = 0;
            }
            int idx = 0;
            while (!rowQueue.isEmpty()) {
                int cur = rowQueue.pollFirst();
                if (rowQueue.isEmpty()) {
                    board[rr][idx++] = cur;
                } else if (rowQueue.peekFirst() == cur) {
                    board[rr][idx++] = cur * 2;
                    rowQueue.pollFirst();
                } else {
                    board[rr][idx++] = cur;
                }
            }
        }
        return board;
    }

    private static int[][] getBoard(int[][] b) {
        int[][] board = new int[N][N];
        for (int i = 0; i < N; i++) {
            board[i] = Arrays.copyOf(b[i], N);
        }
        return board;
    }

    public static int[][] moveRight(int[][] b) {
        int[][] board = getBoard(b);
        for (int rr = 0; rr < N; rr++) {
            ArrayDeque<Integer> rowQueue = new ArrayDeque<>();
            for (int cc = 0; cc < N; cc++) {
                if (board[rr][cc] == 0) continue;
                rowQueue.addLast(board[rr][cc]);
                board[rr][cc] = 0;
            }
            int idx = N - 1;
            while (!rowQueue.isEmpty()) {
                int cur = rowQueue.pollLast();
                if (rowQueue.isEmpty()) {
                    board[rr][idx--] = cur;
                } else if (rowQueue.peekLast() == cur) {
                    board[rr][idx--] = cur * 2;
                    rowQueue.pollLast();
                } else {
                    board[rr][idx--] = cur;
                }
            }
        }
        return board;
    }

    public static int[][] moveDown(int[][] b) {
        int[][] board = getBoard(b);
        for (int cc = 0; cc < N; cc++) {
            ArrayDeque<Integer> colQueue = new ArrayDeque<>();
            for (int rr = 0; rr < N; rr++) {
                if (board[rr][cc] == 0) continue;
                colQueue.addLast(board[rr][cc]);
                board[rr][cc] = 0;
            }
            int idx = N - 1;
            while (!colQueue.isEmpty()) {
                int cur = colQueue.pollLast();
                if (colQueue.isEmpty()) {
                    board[idx--][cc] = cur;
                } else if (colQueue.peekLast() == cur) {
                    board[idx--][cc] = cur * 2;
                    colQueue.pollLast();
                } else {
                    board[idx--][cc] = cur;
                }
            }
        }
        return board;
    }

    public static int[][] moveUp(int[][] b) {
        int[][] board = getBoard(b);
        for (int cc = 0; cc < N; cc++) {
            ArrayDeque<Integer> colQueue = new ArrayDeque<>();
            for (int rr = 0; rr < N; rr++) {
                if (board[rr][cc] == 0) continue;
                colQueue.addLast(board[rr][cc]);
                board[rr][cc] = 0;
            }
            int idx = 0;
            while (!colQueue.isEmpty()) {
                int cur = colQueue.pollFirst();
                if (colQueue.isEmpty()) {
                    board[idx++][cc] = cur;
                } else if (colQueue.peekFirst() == cur) {
                    board[idx++][cc] = cur * 2;
                    colQueue.pollFirst();
                } else {
                    board[idx++][cc] = cur;
                }
            }
        }
        return board;
    }

}
