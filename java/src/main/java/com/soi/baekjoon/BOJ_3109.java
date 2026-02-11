package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3109 {
    private static final int[][] movement = new int[][]{{-1, 1}, {0, 1}, {1, 1}};
    private static int r, c, answer;
    private static boolean[][] wall;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        wall = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                wall[i][j] = line.charAt(j) == 'x';
            }
        }

        for (int i = 0; i < r; i++) {
            if (!wall[i][0]) {
                wall[i][0] = true;
                if (dfs(i, 0)) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }

    private static boolean dfs(int rr, int cc) {
        if (cc == c - 1) {
            return true;
        }
        for (int[] m : movement) {
            int nR = rr + m[0];
            int nC = cc + m[1];
            if (!inRange(nR, nC) || wall[nR][nC]) continue;
            wall[nR][nC] = true;
            if (dfs(nR, nC)) {
                return true;
            }
        }
        return false;
    }

    private static boolean inRange(int i, int j) {
        return i >= 0 && i < r && j >= 0 && j < c;
    }
}
