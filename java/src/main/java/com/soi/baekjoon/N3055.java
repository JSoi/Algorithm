package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N3055 {
    private static final String IMPOSSIBLE = "KAKTUS";
    private static final int CAN_PASS = -1, ROCK = -2;
    private static final int[][] movement = new int[][]{{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    private static int[][] map;
    private static int r, c, endR, endC;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(tok.nextToken());
        c = Integer.parseInt(tok.nextToken());
        map = new int[r][c];
        int startR = 0, startC = 0;
        endR = 0;
        endC = 0;
        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                char val = line.charAt(j);
                map[i][j] = switch (val) {
                    case 'S' -> {
                        startR = i;
                        startC = j;
                        yield CAN_PASS;
                    }
                    case 'D' -> {
                        endR = i;
                        endC = j;
                        yield CAN_PASS;
                    }
                    case 'X' -> ROCK;
                    case '.' -> CAN_PASS;
                    default -> 0;
                };
            }
        }
        fillWater();
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[r][c];
        visited[startR][startC] = true;
        queue.offer(new int[]{startR, startC, 0});
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currR = curr[0];
            int currC = curr[1];
            int currTime = curr[2];
//            System.out.println(Arrays.toString(curr));
            if (currR == endR && currC == endC) {
                System.out.println(currTime);
                return;
            }
            for (int[] m : movement) {
                int newR = currR + m[0];
                int newC = currC + m[1];
                int newTime = currTime + 1;
                if (!inRange(newR, newC) || visited[newR][newC] || map[newR][newC] == ROCK ||
                        (map[newR][newC] >= 0 && newTime >= map[newR][newC])) {
                    continue;
                }
                visited[newR][newC] = true;
                queue.offer(new int[]{newR, newC, newTime});
            }
        }
        System.out.println(IMPOSSIBLE);
    }

    private static void fillWater() {
        boolean[][] visited = new boolean[r][c];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 0) {
                    visited[i][j] = true;
                    queue.offer(new int[]{i, j, 0});
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int curR = curr[0];
            int curC = curr[1];
            int curSecond = curr[2];
            for (int[] m : movement) {
                int nextR = curR + m[0];
                int nextC = curC + m[1];
                if (!inRange(nextR, nextC) || visited[nextR][nextC] ||
                        (nextR == endR && nextC == endC) ||
                        map[nextR][nextC] != CAN_PASS) {
                    continue;
                }
                visited[nextR][nextC] = true;
                map[nextR][nextC] = curSecond + 1;
                queue.offer(new int[]{nextR, nextC, curSecond + 1});
            }
        }
    }

    private static boolean inRange(int rr, int cc) {
        return rr >= 0 && rr < r && cc >= 0 && cc < c;
    }
}
