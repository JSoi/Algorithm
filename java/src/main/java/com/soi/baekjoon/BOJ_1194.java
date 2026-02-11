package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1194 {
    private static final int[][] movement = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static char[][] map;
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] rc = br.readLine().split(" ");
        int row = Integer.parseInt(rc[0]);
        int col = Integer.parseInt(rc[1]);
        map = new char[row][col];
        visited = new boolean[row][col][1 << 7 - 1];
        int startR = 0;
        int startC = 0;
        for (int i = 0; i < row; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < col; j++) {
                if (map[i][j] == '0') {
                    startR = i;
                    startC = j;
                }
            }
        }
        visited[startR][startC][0] = true;
        Queue<Point> points = new LinkedList<>();
        points.offer(new Point(startR, startC, 0, 0));
        while (!points.isEmpty()) {
            Point point = points.poll();
            int r = point.r;
            int c = point.c;
            if (map[r][c] == '1') {
                System.out.println(point.count);
                return;
            }
            for (int[] m : movement) {
                int nR = r + m[0];
                int nC = c + m[1];
                int mask = point.mask;
                int count = point.count;
                int nextMask;
                if (!inRange(nR, nC) || map[nR][nC] == '#' || visited[nR][nC][nextMask = nextMask(nR, nC, mask)]) {
                    continue;
                }
                // 키를 요구하는 길
                if (map[nR][nC] >= 'A' && map[nR][nC] <= 'F') {
                    if ((mask & (1 << map[nR][nC] - 'A')) != 0) {
                        visited[nR][nC][nextMask] = true;
                        points.offer(new Point(nR, nC, nextMask, count + 1));
                    }
                }
                // 일반 길 (빈 칸 & 열쇠)
                else {
                    visited[nR][nC][nextMask] = true;
                    points.offer(new Point(nR, nC, nextMask, count + 1));
                }
            }
        }
        System.out.println(-1);
    }

    private static int nextMask(int r, int c, int currentMask) {
        if (map[r][c] >= 'a' && map[r][c] <= 'f') {
            return currentMask | (1 << (map[r][c] - 'a'));
        }
        return currentMask;
    }

    private static boolean inRange(int r, int c) {
        return (r >= 0 && r < map.length && c >= 0 && c < map[0].length);
    }


    private static class Point {
        int r;
        int c;
        int mask;
        int count;

        public Point(int r, int c, int mask, int count) {
            this.r = r;
            this.c = c;
            this.mask = mask;
            this.count = count;
        }
    }
}
