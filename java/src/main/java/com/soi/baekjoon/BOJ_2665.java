package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2665 {
    public static final int MAX = Integer.MAX_VALUE;
    private static final int[][] movement = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static int n;
    private static int[][] breakArr;
    private static boolean[][] map;
    private static int minBreakCount;

    public static void main(String[] args) throws IOException {
        init();
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0}); // {r, c, breakCount}
        breakArr[0][0] = 0;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            if (curr[0] == n - 1 && curr[1] == n - 1) {
                minBreakCount = Math.min(minBreakCount, curr[2]);
            }
            for (int[] m : movement) {
                int nR = curr[0] + m[0];
                int nC = curr[1] + m[1];
                int nB;
                if (!inRange(nR, nC) || breakArr[nR][nC] <= (nB = map[nR][nC] ? curr[2] : curr[2] + 1) || minBreakCount < nB) {
                    continue;
                }
                breakArr[nR][nC] = nB;
                queue.offer(new int[]{nR, nC, nB});
            }
        }
        System.out.println(minBreakCount);
    }

    private static boolean inRange(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        breakArr = new int[n][n];
        map = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j) == '1';
            }
        }
        for (int[] b : breakArr) {
            Arrays.fill(b, MAX);
        }
        minBreakCount = MAX;
    }
}
