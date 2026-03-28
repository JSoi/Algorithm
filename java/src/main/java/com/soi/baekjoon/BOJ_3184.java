package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3184 {
    private static final int[][] move = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static char[][] map;
    private static boolean[][] visited;
    private static int r, c, sheep, wolf;

    // o = lamb, v = wolf
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            map[i] = line.toCharArray();
        }
        visited = new boolean[r][c];
        int totalSheep = 0;
        int totalWolf = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (visited[i][j] || map[i][j] == '#') continue;
                sheep = 0;
                wolf = 0;
                visited[i][j] = true;
                dfs(i, j);
                if (sheep > wolf) {
                    totalSheep += sheep;
                } else {
                    totalWolf += wolf;
                }
            }
        }
        System.out.println(totalSheep + " " + totalWolf);
    }

    private static void dfs(int rr, int cc) {
        if (map[rr][cc] == 'o') {
            sheep++;
        } else if (map[rr][cc] == 'v') {
            wolf++;
        }
        for (int[] mm : move) {
            int nR = rr + mm[0];
            int nC = cc + mm[1];
            if (!inRange(nR, nC) || visited[nR][nC] || map[nR][nC] == '#') {
                continue;
            }
            visited[nR][nC] = true;
            dfs(nR, nC);
        }
    }

    private static boolean inRange(int rr, int cc) {
        return rr >= 0 && rr < r && cc >= 0 && cc < c;
    }
}
