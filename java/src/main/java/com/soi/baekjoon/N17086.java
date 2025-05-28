package com.soi.baekjoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N17086 {
    static int garo, sero, min, max;
    static int[][] map;
    final static int[] dg = {1, -1, 0, 0, 1, 1, -1, -1};
    final static int[] ds = {1, -1, 1, -1, -1, 0, 1, 0,};
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fLine = br.readLine();
        sero = Integer.parseInt(fLine.split(" ")[0]);
        garo = Integer.parseInt(fLine.split(" ")[1]);
        map = new int[sero][garo];
        for (int i = 0; i < sero; i++) {
            StringTokenizer tok = new StringTokenizer(br.readLine());
            for (int j = 0; j < garo; j++) {
                map[i][j] = Integer.parseInt(tok.nextToken());
            }
        }
        max = 0;
        for (int i = 0; i < sero; i++) {
            for (int j = 0; j < garo; j++) {
                if (map[i][j] == 0) {
                    min = Integer.MAX_VALUE;
                    visit = new boolean[sero][garo];
                    findAnn(i, j);
                    max = Math.max(max, min);

                }
            }
        }
        System.out.println(max);
    }

    static void findAnn(int s, int g) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(s, g, 0));
        visit[s][g] = true;
        while (!queue.isEmpty()) {
            Point now = queue.poll();
            if (map[now.s][now.g] == 1) {
                min = Math.min(min, now.count);
                return;
            }
            for (int i = 0; i < 8; i++) {
                int ns = now.s + ds[i];
                int ng = now.g + dg[i];
                if (isRange(ns, ng) && !visit[ns][ng]) {
                    visit[ns][ng] = true;
                    queue.offer(new Point(ns, ng, now.count + 1));
                }
            }
        }
    }

    static boolean isRange(int s, int g) {
        if (s >= 0 && s < sero && g >= 0 && g < garo) {
            return true;
        }
        return false;
    }

    static class Point {
        int s;
        int g;
        int count;

        public Point(int s, int g, int count) {
            this.s = s;
            this.g = g;
            this.count = count;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "s=" + s +
                    ", g=" + g +
                    ", count=" + count +
                    '}';
        }
    }
}
