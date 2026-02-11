package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BOJ_11559 {
    private static final int[][] pos = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static final char[][] map = new char[12][6];
    private static Set<int[]> pops = new HashSet<>();
    private static boolean[][] visit = new boolean[12][6];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 12; i++) {
            String line = br.readLine();
            map[i] = line.toCharArray();
        }
        int answer = 0;
        while (true) {
            Set<int[]> pops = puyosToPop();
            if (pops.isEmpty()) break;
            popPuyo();
            organizeMap();
            answer++;
        }
        System.out.println(answer);
    }

    private static Set<int[]> puyosToPop() {
        pops = new HashSet<>();
        visit = new boolean[12][6];
        for (int r = 0; r < 12; r++) {
            for (int c = 0; c < 6; c++) {
                if (map[r][c] == '.' || visit[r][c]) {
                    continue;
                }
                bfs(r, c);
            }
        }
        return pops;
    }

    private static void bfs(int rr, int cc) {
        char color = map[rr][cc];

        Set<int[]> groups = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();

        groups.add(new int[]{rr, cc});
        queue.offer(new int[]{rr, cc});
        visit[rr][cc] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int[] po : pos) {
                int newRr = curr[0] + po[0];
                int newCc = curr[1] + po[1];
                if (!inRange(newRr, newCc) || visit[newRr][newCc] || map[newRr][newCc] != color) {
                    continue;
                }
                groups.add(new int[]{newRr, newCc});
                queue.offer(new int[]{newRr, newCc});
                visit[newRr][newCc] = true;
            }
        }
        if (groups.size() >= 4) {
            pops.addAll(groups);
        }
    }

    private static void popPuyo() {
        for (int[] puyos : pops) {
            map[puyos[0]][puyos[1]] = '.';
        }
    }

    // 아래로 모든 뿌요들 당기기
    private static void organizeMap() {
        for (int c = 0; c < 6; c++) {
            StringBuilder chars = new StringBuilder();
            for (int r = 0; r < 12; r++) {
                if (map[r][c] == '.') {
                    continue;
                }
                chars.append(map[r][c]);
            }
            chars.insert(0, ".".repeat(12 - chars.length()));
            for (int r = 0; r < 12; r++) {
                map[r][c] = chars.charAt(r);
            }
        }

    }

    private static boolean inRange(int rr, int cc) {
        return rr >= 0 && rr < 12 && cc >= 0 && cc < 6;
    }
}
