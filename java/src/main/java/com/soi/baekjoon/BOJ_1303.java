package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1303 {
    static final int[] dx = {0, 0, 1, -1};
    static final int[] dy = {1, -1, 0, 0};
    static int n, m, blue, white;
    static long count;
    static boolean[][] visit;
    static char[][] map;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        try {
            line = br.readLine();
            n = Integer.parseInt(line.split(" ")[0]);
            m = Integer.parseInt(line.split(" ")[1]);
            map = new char[m][n];
            visit = new boolean[m][n];
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < m; i++) {
            String thisLine = br.readLine();
            map[i] = thisLine.toCharArray();
        }
    }

    public static void main(String[] args) throws IOException {

        input();
        solve();
        System.out.println(white + " " + blue);
    }

    static void solve() {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                count = 1;
                if (visit[i][j]) {
                    continue;
                }
                dfs(i, j, map[i][j]);
                if (map[i][j] == 'W') {
                    white += count * count;
                } else {
                    blue += count * count;
                }
            }
        }
    }

    static void dfs(int nowX, int nowY, char targetColor) {
        visit[nowX][nowY] = true;
        for (int x = 0; x < 4; x++) {
            if (nowX + dx[x] < 0 || nowX + dx[x] >= m || nowY + dy[x] < 0 || nowY + dy[x] >= n
                    || visit[nowX + dx[x]][nowY + dy[x]] || map[nowX + dx[x]][nowY + dy[x]] != targetColor) {
                continue;
            }
            count++;
            dfs(nowX + dx[x], nowY + dy[x], targetColor);

        }
    }
}
