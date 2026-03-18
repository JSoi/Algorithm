package com.soi.programmers;

import java.util.Arrays;

public class POG_468381 {
    public static void main(String[] args) {
        int s1 = solution(
                new int[][]{
                        {1, 0, -1},
                        {0, 0, 7},
                        {0, 0, 2}
                }
        );
        System.out.println(s1);
    }

    private static int r, c, answer;
    private static int[][] map;
    private static boolean[][][] visit;
    private static final int[][] dir = new int[][]{{0, -1}, {1, 0}, {0, 1}, {-1, 0}}; // L, D, R, U
    private static final int LEFT = 0, DOWN = 1, RIGHT = 2, UP = 3;
    private static boolean[][] type = new boolean[][]{
            {false, false, false, false},  // L, D, R, U
            {true, false, true, false},
            {false, true, false, true},
            {true, true, true, true},
            {true, false, false, true},
            {false, false, true, true},
            {false, true, true, false},
            {true, true, false, false},
    };

    public static int solution(int[][] grid) {
        r = grid.length;
        c = grid[0].length;
        map = new int[r][c];
        for (int i = 0; i < r; i++) {
            map[i] = Arrays.copyOf(grid[i], grid[i].length);
        }
        // (0,0) -> #1
        // (r-1,c-1) -> #1 or #2
        visit = new boolean[r][c][4];
        visit[0][0][LEFT] = true;
        visit[r - 1][c - 1][map[r - 1][c - 1] == 1 ? RIGHT : DOWN] = true;
        dfs(0, 0, LEFT);
        return answer;
    }

    private static void dfs(int rr, int cc, int inDir) {
        int currentType = map[rr][cc];
        if (rr == r - 1 && cc == c - 1) {
            if (isComplete()) {
                answer++;
            }
            return;
        }
        for (int outDir = 0; outDir < 4; outDir++) {
            int nr = rr + dir[outDir][0];
            int nc = cc + dir[outDir][1];
            int nextInDir = opposite(outDir);
            if (!canChangeType(currentType, inDir, outDir) || visit[rr][cc][outDir]
                    || !inRange(nr, nc) || map[nr][nc] == -1 || visit[nr][nc][nextInDir]) continue;
            if (map[nr][nc] == 0) { // empty block
                for (int t = 1; t <= 7; t++) {
                    if (!type[t][nextInDir] || !canPlaceRail(nr, nc, t)) continue;
                    map[nr][nc] = t;
                    visit[rr][cc][outDir] = visit[nr][nc][nextInDir] = true;
                    dfs(nr, nc, nextInDir);
                    visit[rr][cc][outDir] = visit[nr][nc][nextInDir] = false;
                    map[nr][nc] = 0;
                }
            } else { // fixed block
                int nextType = map[nr][nc];
                if (!type[nextType][nextInDir]) continue;
                visit[rr][cc][outDir] = visit[nr][nc][nextInDir] = true;
                dfs(nr, nc, nextInDir);
                visit[rr][cc][outDir] = visit[nr][nc][nextInDir] = false;
            }
        }
    }

    private static boolean canPlaceRail(int rr, int cc, int t) {
        for (int d = 0; d < 4; d++) {
            if (!type[t][d]) continue;
            int nr = rr + dir[d][0];
            int nc = cc + dir[d][1];
            if (!inRange(nr, nc) || map[nr][nc] == -1) {
                return false;
            }
        }
        return true;
    }

    private static boolean inRange(int rr, int cc) {
        return rr >= 0 && rr < r && cc >= 0 && cc < c;
    }

    private static boolean isComplete() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int t = map[i][j];
                if (t <= 0) continue;
                for (int d = 0; d < 4; d++) {
                    if (type[t][d] != visit[i][j][d]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static boolean canChangeType(int railType, int inDir, int outDir) {
        if (!type[railType][inDir] || !type[railType][outDir]) return false;
        if (railType == 3) {
            return outDir == opposite(inDir);
        }
        return inDir != outDir;
    }

    private static int opposite(int d) {
        return (d + 2) % 4;
    }
}
