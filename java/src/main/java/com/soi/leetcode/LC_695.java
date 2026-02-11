package com.soi.leetcode;

public class LC_695 {
    int count;
    boolean[][] visit;
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    int[][] map;

    public int maxAreaOfIsland(int[][] grid) {
        map = grid;
        visit = new boolean[grid.length][grid[0].length];
        count = 0;
        int area = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 1 && !visit[i][j]) {
                    visit[i][j] = true;
                    count = 0;
                    dfs(i, j);
                    area = Math.max(area, count);
                }
            }
        }
        return area;
    }

    public void dfs(int s, int g) {
        count++;
        for (int i = 0; i < 4; i++) {
            int ds = s + dx[i];
            int dg = g + dy[i];
            if (ds < 0 || ds >= map.length || dg < 0 || dg >= map[0].length || visit[ds][dg] || map[ds][dg] == 0) {
                continue;
            }
            visit[ds][dg] = true;
            dfs(ds, dg);
        }
    }
}
