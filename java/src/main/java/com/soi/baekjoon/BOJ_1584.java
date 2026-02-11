package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class BOJ_1584 {
    static final int N = 501;
    static final int[][] movements = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int[][] map = new int[N][N];
    static int[][] dist = new int[N][N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int dangerCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < dangerCount; i++) {
            String[] input = br.readLine().split(" ");
            int x1 = Integer.parseInt(input[0]);
            int y1 = Integer.parseInt(input[1]);
            int x2 = Integer.parseInt(input[2]);
            int y2 = Integer.parseInt(input[3]);
            fill(Math.min(x1, x2), Math.min(y1, y2), Math.max(x1, x2), Math.max(y1, y2), 1);
        }
        for (int[] d : dist) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        int killCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < killCount; i++) {
            String[] input = br.readLine().split(" ");
            int x1 = Integer.parseInt(input[0]);
            int y1 = Integer.parseInt(input[1]);
            int x2 = Integer.parseInt(input[2]);
            int y2 = Integer.parseInt(input[3]);
            fill(Math.min(x1, x2), Math.min(y1, y2), Math.max(x1, x2), Math.max(y1, y2), 2);
        }

        int[][] dist = new int[N][N];
        for (int[] d : dist) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        dist[0][0] = 0;
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        queue.add(new int[]{0, 0, 0});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0], c = cur[1], cost = cur[2];
            if (cost > dist[r][c]) continue;
            if (r == 500 && c == 500) {
                System.out.println(cost);
                return;
            }

            for (int[] m : movements) {
                int nr = r + m[0];
                int nc = c + m[1];
                if (nr < 0 || nc < 0 || nr >= N || nc >= N || map[nr][nc] == 2) continue;
                int nCost = cost + map[nr][nc];
                if (dist[nr][nc] > nCost) {
                    dist[nr][nc] = nCost;
                    queue.offer(new int[]{nr, nc, nCost});
                }
            }
        }
        System.out.println(-1);
    }

    static void fill(int r1, int c1, int r2, int c2, int value) {
        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                map[i][j] = value;
            }
        }
    }
}
