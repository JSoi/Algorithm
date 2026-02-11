package com.soi.programmers;

public class POG_181832 {
    private final int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int cr = 0;
        int cc = 0;
        int di = 0;
        for (int i = 1; i <= n * n; i++) {
            answer[cr][cc] = i;
            int nr = cr + dir[di][0];
            int nc = cc + dir[di][1];
            if (nr < 0 || nr >= n || nc < 0 || nc >= n || answer[nr][nc] > 0) {
                di = (di + 1) % 4;
            }
            cr += dir[di][0];
            cc += dir[di][1];
        }
        return answer;
    }
}
