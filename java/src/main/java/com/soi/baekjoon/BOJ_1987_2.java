package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ_1987_2 {
    private static int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    private static int r, c, answer;
    private static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
        }
        dfs(0, 0, (1L<<alphabetToInt(map[0][0])));
        System.out.println(answer);
    }

    private static void dfs(int rr, int cc, long status) {
        answer = Math.max(answer, Long.bitCount(status));
        for (int[] dd : dir) {
            int nr = rr + dd[0];
            int nc = cc + dd[1];
            if (!inRange(nr, nc) || (status & (1L << alphabetToInt(map[nr][nc]))) != 0) {
                continue;
            }
            long nextStatus = status | (1L << alphabetToInt(map[nr][nc]));
            dfs(nr, nc, nextStatus);
        }
    }

    private static int alphabetToInt(char alp) {
        return alp - 'A';
    }

    private static boolean inRange(int rr, int cc) {
        return rr >= 0 && rr < r && cc >= 0 && cc < c;
    }
}
