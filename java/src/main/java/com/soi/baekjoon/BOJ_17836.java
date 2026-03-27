package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17836 {
    private static int r, c;
    private static int[][] movement = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[][] map = new int[r][c];
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][][] visited = new boolean[r][c][2];
        Queue<Point> points = new ArrayDeque<>();
        points.offer(new Point(0, 0, 0, false));
        int answer = Integer.MAX_VALUE;
        while (!points.isEmpty()) {
            Point curr = points.poll();
            if (curr.row == r - 1 && curr.col == c - 1) {
                answer = Math.min(answer, curr.dist);
            }
            for (int[] mm : movement) {
                int nR = curr.row + mm[0];
                int nC = curr.col + mm[1];
                if (!inRange(nR, nC) || curr.dist >= t) {
                    continue;
                }
                boolean nG = curr.hasGram || (map[nR][nC] == 2);
                if ((!curr.hasGram && map[nR][nC] == 1) || visited[nR][nC][nG ? 1 : 0]) {
                    continue;
                }
                visited[nR][nC][nG ? 1 : 0] = true;
                points.offer(new Point(nR, nC, curr.dist + 1, nG));
            }
        }
        System.out.println(answer == Integer.MAX_VALUE ? "Fail" : answer);
    }

    private static boolean inRange(int rr, int cc) {
        return rr >= 0 && rr < r && cc >= 0 && cc < c;
    }

    private static class Point {
        int row;
        int col;
        int dist;
        boolean hasGram;

        public Point(int row, int col, int dist, boolean hasGram) {
            this.row = row;
            this.col = col;
            this.dist = dist;
            this.hasGram = hasGram;
        }
    }
}
