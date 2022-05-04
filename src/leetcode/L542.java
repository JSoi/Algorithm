package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class L542 {
    final int[] dx = {0, 0, 1, -1};
    final int[] dy = {1, -1, 0, 0};
    int garo, sero;

    public int[][] updateMatrix(int[][] mat) {
        // shortest distance = bfs
        sero = mat.length;
        garo = mat[0].length;
        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < sero; i++) {
            for (int j = 0; j < garo; j++) {
                if (mat[i][j] == 0) {
                    mat[i][j] = 0;
                    queue.offer(new Point(i, j, 0));
                } else {
                    mat[i][j] = Integer.MAX_VALUE / 2;
                }
            }
        }
        while (!queue.isEmpty()) {
            Point now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ns = now.s + dx[i];
                int ng = now.g + dy[i];
                if (isRange(ns, ng) && mat[now.s][now.g] < mat[ns][ng]) {
                    mat[ns][ng] = mat[now.s][now.g] + 1;
                    queue.offer(new Point(ns, ng, now.dist + 1));
                }
            }
        }
        return mat;
    }

    public boolean isRange(int s, int g) {
        if (s < 0 || g < 0 || s >= sero || g >= garo) {
            return false;
        }
        return true;
    }

    class Point {
        int s, g, dist;

        public Point(int s, int g, int dist) {
            this.s = s;
            this.g = g;
            this.dist = dist;
        }
    }
}
