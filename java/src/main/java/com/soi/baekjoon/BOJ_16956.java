package com.soi.baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16956 {
    private static final int[][] movement = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    private static int r, c;
    private static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
        }
        boolean[][] visited = new boolean[r][c];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 'W') {
                    if (hasSheepNearby(i, j)) {
                        System.out.println(0);
                        return;
                    }
                    visited[i][j] = true;
                    queue.offer(new int[]{i, j});
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int[] mm : movement) {
                int nR = mm[0] + curr[0];
                int nC = mm[1] + curr[1];
                if (!inRange(nR, nC) || visited[nR][nC] || map[nR][nC] == 'D') {
                    continue;
                }
                visited[nR][nC] = true;
                if (hasSheepNearby(nR, nC)) {
                    if (map[nR][nC] == '.') {
                        map[nR][nC] = 'D';
                    }
                } else {
                    queue.offer(new int[]{nR, nC});
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.append("1\n");
        for (int i = 0; i < r; i++) {
            bw.append(String.valueOf(map[i])).append("\n");
        }
        bw.flush();

    }

    private static boolean inRange(int rr, int cc) {
        return rr >= 0 && rr < r && cc >= 0 && cc < c;
    }

    private static boolean hasSheepNearby(int rr, int cc) {
        for (int[] m : movement) {
            int nR = rr + m[0];
            int nC = cc + m[1];
            if (!inRange(nR, nC)) {
                continue;
            }
            if (map[nR][nC] == 'S') {
                return true;
            }
        }
        return false;
    }
}
