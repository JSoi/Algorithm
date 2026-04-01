package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_13565 {
    private static final int[][] movement = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        boolean[][] map = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = line.charAt(j) == '0';
            }
        }
        boolean[][] visit = new boolean[r][c];
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < c; i++) {
            queue.offer(new int[]{0, i});
        }
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == r - 1) {
                System.out.println("YES");
                return;
            }
            for (int[] m : movement) {
                int nR = cur[0] + m[0];
                int nC = cur[1] + m[1];
                if (!inRange(nR, nC, r, c) || visit[nR][nC] || !map[nR][nC]) {
                    continue;
                }
                queue.offer(new int[]{nR, nC});
                visit[nR][nC] = true;
            }
        }
        System.out.println("NO");
    }

    private static boolean inRange(int rr, int cc, int r, int c) {
        return rr >= 0 && rr < r && cc >= 0 && cc < c;
    }
}
