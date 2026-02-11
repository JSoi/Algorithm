package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1987 {
    private static final int[][] movement = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    private static char[][] map;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int row = Integer.parseInt(line[0]);
        int col = Integer.parseInt(line[1]);
        map = new char[row][col];
        for (int r = 0; r < row; r++) {
            map[r] = br.readLine().toCharArray();
        }
        dfs(0, 0, 1 << (map[0][0] - 'A'), 1);
        System.out.println(answer);
    }

    private static void dfs(int r, int c, int visited, int count) {
        answer = Math.max(answer, count);
        for (int[] m : movement) {
            int nR = r + m[0];
            int nC = c + m[1];
            int nextChar;
            if (nR < 0 || nR >= map.length || nC < 0 || nC >= map[0].length ||
                    (visited & (1 << (nextChar = map[nR][nC] - 'A'))) != 0) {
                continue;
            }
            dfs(nR, nC, visited | (1 << nextChar), count + 1);
        }
    }
}
