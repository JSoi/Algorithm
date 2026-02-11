package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1012 {
    final static int[] dr = {0, 0, -1, 1};
    final static int[] dc = {1, -1, 0, 0};
    static BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int col, row, count;
    static boolean[][] map;
    static boolean[][] visit;

    static void inputAndFlow() throws IOException {
        int testCase = Integer.parseInt(buf.readLine());
        for (int tc = 0; tc < testCase; tc++) {
            String tcase = buf.readLine();
            col = Integer.parseInt(tcase.split(" ")[0]);
            row = Integer.parseInt(tcase.split(" ")[1]);
            map = new boolean[row][col];
            visit = new boolean[row][col];
            int posCount = Integer.parseInt(tcase.split(" ")[2]);
            for (int lc = 0; lc < posCount; lc++) {
                String miniLine = buf.readLine();
                int miniCol = Integer.parseInt(miniLine.split(" ")[0]);
                int miniRow = Integer.parseInt(miniLine.split(" ")[1]);
                map[miniRow][miniCol] = true;
            }
            count = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (map[i][j] && !visit[i][j]) {
                        count++;
                        go(i, j);
                    }
                }
            }
            sb.append(count + "\n");
        }
    }

    static void go(int r, int c) {
        visit[r][c] = true;
        for (int i = 0; i < 4; i++) {
            if (r + dr[i] < 0 || r + dr[i] >= row || c + dc[i] < 0 || c + dc[i] >= col || visit[r + dr[i]][c + dc[i]]
                    || !map[r + dr[i]][c + dc[i]]) {
                continue;
            }
            go(r + dr[i], c + dc[i]);
        }
    }

    public static void main(String[] args) throws IOException {

        inputAndFlow();
        System.out.println(sb.toString());
    }

}
