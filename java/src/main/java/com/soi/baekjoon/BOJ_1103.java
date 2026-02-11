package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1103 {
    private static final int[][] movement = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    private static char[][] map;
    private static int[][] dp;
    private static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int row = Integer.parseInt(input[0]);
        int col = Integer.parseInt(input[1]);
        map = new char[row][col];
        dp = new int[row][col];
        for (int r = 0; r < row; r++) {
            String line = br.readLine();
            for (int c = 0; c < col; c++) {
                map[r][c] = line.charAt(c);
                dp[r][c] = -1; // initialize
            }
        }
        visit = new boolean[row][col];
        System.out.println(findMaxMove(0, 0));
    }

    private static int findMaxMove(int r, int c) {
        if (r < 0 || r >= map.length || c < 0 || c >= map[0].length || map[r][c] == 'H') {
            // 방문할 수 없는 경우
            return 0;
        }
        if (visit[r][c]) { // 방문한 곳을 또 방문한 경우
            return -1;
        }
        if (dp[r][c] != -1) { // 이전에 계산한 위치
            return dp[r][c];
        }
        int offset = map[r][c] - '0';
        int maxMoves = 0;
        visit[r][c] = true;
        for (int[] m : movement) {
            int nR = r + m[0] * offset;
            int nC = c + m[1] * offset;
            int move = findMaxMove(nR, nC);
            if (move == -1) { // 무한
                return -1;
            }
            maxMoves = Math.max(maxMoves, move);
        }
        visit[r][c] = false;
        // 모든 계산이 끝난 후 DP 값 할당
        dp[r][c] = maxMoves + 1;
        return dp[r][c];
    }
}
