package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N1486 {
    private static int r, c;
    private static int timeLimit, maxDiff;
    private static int[][] map;
    private static final int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        input();
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        pq.offer(new int[]{0, 0, 0});
        int[][] dist = new int[r][c];
        for (int[] d : dist) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        dist[0][0] = 0;
        int maxHeight = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            System.out.println(Arrays.toString(cur));
            int row = cur[0], col = cur[1], time = cur[2];
            maxHeight = Math.max(maxHeight, map[row][col]);
            if (time > dist[row][col]) continue;
            for (int[] d : dir) {
                int nr = row + d[0];
                int nc = col + d[1];
                if (nr < 0 || nr >= r || nc < 0 || nc >= c) continue;

                int h1 = map[row][col];
                int h2 = map[nr][nc];
                int diff = Math.abs(h1 - h2);
                if (diff > maxDiff) continue;

                int cost = h1 >= h2 ? 1 : (h2 - h1) * (h2 - h1);
                int nextCost = time + cost;
                if (nextCost <= timeLimit && dist[nr][nc] > nextCost) {
                    dist[nr][nc] = nextCost;
                    pq.offer(new int[]{nr, nc, nextCost});
                }
            }
        }
        System.out.println(maxHeight);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(tok.nextToken());
        c = Integer.parseInt(tok.nextToken());
        maxDiff = Integer.parseInt(tok.nextToken());
        timeLimit = Integer.parseInt(tok.nextToken());
        map = new int[r][c];
        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = toNum(line.charAt(j));
            }
        }
//        System.out.println(Arrays.deepToString(map));
    }

    private static int toNum(char c) {
        if (c >= 'A' && c <= 'Z') {
            return c - 'A';
        }
        return c - 'a' + 26;
    }
}
