package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1743 {
    static boolean[][] map, visit;
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, 1, -1};
    static int x, y, max, count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        int cnt = Integer.parseInt(st.nextToken());
        map = new boolean[x][y];
        visit = new boolean[x][y];
        max = 0;
        for (int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = true;
        }
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (!visit[i][j] && map[i][j]) {
                    count = 0;
                    dfs(i, j);
                    max = Math.max(max, count);
                }
            }
        }
        System.out.println(max);
    }

    static void dfs(int nx, int ny) {
        visit[nx][ny] = true;
        count++;
        for (int i = 0; i < 4; i++) {
            int ndx = nx + dx[i];
            int ndy = ny + dy[i];
            if (ndx < 0 || ndy < 0 || ndx >= x || ndy >= y || !map[ndx][ndy] || visit[ndx][ndy]) {
                continue;
            }
            dfs(ndx, ndy);
        }
    }
}
