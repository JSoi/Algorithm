package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class N2206 {
    private static final int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] rowAndCol = br.readLine().split(" ");
        int row = Integer.parseInt(rowAndCol[0]);
        int col = Integer.parseInt(rowAndCol[1]);
        int[][][] dist = new int[row][col][2];
        boolean[][] map = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            String rowLine = br.readLine();
            for (int j = 0; j < col; j++) {
                map[i][j] = rowLine.charAt(j) == '1';
            }
        }
        for (int[][] d : dist) {
            for (int[] dd : d) {
                Arrays.fill(dd, Integer.MAX_VALUE);
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        dist[0][0][0] = 1;
        queue.offer(new int[]{0, 0, 0, 1});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            int cc = cur[2];
            int len = cur[3];
            if (r == row - 1 && c == col - 1) {
                System.out.println(len);
                return;
            }
            for (int[] d : dir) {
                int nr = r + d[0];
                int nc = c + d[1];
                if (nr < 0 || nr >= row || nc < 0 || nc >= col) continue;
                int nextLen = len + 1;
                if (map[nr][nc]) {
                    if (cc == 0 && dist[nr][nc][1] > nextLen) {
                        dist[nr][nc][1] = nextLen;
                        queue.offer(new int[]{nr, nc, 1, nextLen});
                    }
                } else {
                    if (dist[nr][nc][cc] > nextLen) {
                        dist[nr][nc][cc] = nextLen;
                        queue.offer(new int[]{nr, nc, cc, nextLen});
                    }
                }
            }
        }
        int min = Math.min(dist[row - 1][col - 1][1], dist[row - 1][col - 1][0]);
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }


}
