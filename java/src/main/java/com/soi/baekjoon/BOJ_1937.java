package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1937 {
    static final int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int[][] forest;
    static int N;
    static int[][] depth;

    public static void main(String[] args) throws IOException {
        init();
        int answer = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (depth[r][c] != 0) continue;
                answer = Math.max(answer, getMaxDepth(r, c));
            }
        }
        System.out.println(answer);
    }

    private static int getMaxDepth(int r, int c) {
        if (depth[r][c] != 0) return depth[r][c];
        int subDepth = 0;
        for (int[] d : direction) {
            int nR = r + d[0];
            int nC = c + d[1];
            if (!isInBound(nR, nC) || forest[r][c] >= forest[nR][nC]) continue;
            subDepth = Math.max(subDepth, getMaxDepth(nR, nC));
        }
        return depth[r][c] = 1 + subDepth;
    }

    private static boolean isInBound(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        forest = new int[N][N];
        depth = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                forest[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();
    }
}
