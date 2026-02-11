package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2573 {
    private static final int[][] mv = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static int[][] map;
    private static int row, col;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
        row = Integer.parseInt(tok.nextToken());
        col = Integer.parseInt(tok.nextToken());
        map = new int[row][col];
        for (int i = 0; i < row; i++) {
            tok = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(tok.nextToken());
            }
        }
        int year = 0;
        while (true) {
            int islandCount = count();
            if (islandCount == 0) {
                System.out.println(0);
                return;
            } else if (islandCount > 1) {
                break;
            }
            melt();
            year++;
        }
        System.out.println(year);
    }

    private static void melt() {
        int[][] meltCount = new int[row][col];
        for (int i = 1; i < row - 1; i++) {
            for (int j = 1; j < col - 1; j++) {
                if (map[i][j] == 0) {
                    continue;
                }
                meltCount[i][j] = offset(i, j);
            }
        }
        for (int i = 1; i < row - 1; i++) {
            for (int j = 1; j < col - 1; j++) {
                map[i][j] = Math.max(0, map[i][j] - meltCount[i][j]);
            }
        }
    }

    private static int offset(int r, int c) {
        int count = 0;
        for (int[] m : mv) {
            if (map[m[0] + r][m[1] + c] == 0) {
                count++;
            }
        }
        return count;
    }

    private static boolean inRange(int r, int c) {
        return r > 0 && r < row - 1 && c > 0 && c < col - 1;
    }

    private static int count() {
        int count = 0;
        visited = new boolean[row][col];
        for (int i = 1; i < row - 1; i++) {
            for (int j = 1; j < col - 1; j++) {
                if (visited[i][j] || map[i][j] == 0) {
                    continue;
                }
                bfs(i, j);
                count++;
            }
        }
        return count;
    }

    private static void bfs(int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c});
        visited[r][c] = true;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int[] m : mv) {
                int nR = curr[0] + m[0];
                int nC = curr[1] + m[1];
                if (!inRange(nR, nC) || visited[nR][nC] || map[nR][nC] == 0) {
                    continue;
                }
                queue.offer(new int[]{nR, nC});
                visited[nR][nC] = true;
            }
        }
    }
}
