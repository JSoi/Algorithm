package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N2636 {
    private static boolean[][] map;
    private static int r, c;
    private static Set<Integer> meltCandidates;
    private static final int[][] move = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        init();
        int time = 0;
        int blockCount = totalCheeseBlock();
        while (true) {
            meltCandidates = new HashSet<>();
            visited = new boolean[r][c];
            melt();
            time++;
            int count = totalCheeseBlock();
            if (count == 0) {
                break;
            } else {
                blockCount = count;
            }
        }
        System.out.println(time);
        System.out.println(blockCount);
    }

    private static int totalCheeseBlock() {
        int blockCount = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j]) {
                    blockCount++;
                }
            }
        }
        return blockCount;
    }

    private static void melt() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int[] m : move) {
                int x = curr[0] + m[0];
                int y = curr[1] + m[1];
                if (!inRange(x, y) || visited[x][y]) {
                    continue;
                }
                visited[x][y] = true;
                if (map[x][y]) {
                    meltCandidates.add(x * c + y);
                } else {
                    queue.offer(new int[]{x, y});
                }
            }
        }
        for (int pos : meltCandidates) {
            map[pos / c][pos % c] = false;
        }
    }

    private static void bfs(int rr, int cc) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{rr, cc});
        visited[rr][cc] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] m : move) {
                int r = cur[0] + m[0];
                int c = cur[1] + m[1];
                if (!visited[r][c] && map[r][c]) {
                    visited[r][c] = true;
                    queue.offer(new int[]{r, c});
                }
            }
        }
    }

    private static boolean inRange(int rr, int cc) {
        return rr >= 0 && rr < r && cc >= 0 && cc < c;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(tok.nextToken());
        c = Integer.parseInt(tok.nextToken());
        map = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            tok = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < c; j++) {
                map[i][j] = tok.nextToken().equals("1");
            }
        }
    }
}
