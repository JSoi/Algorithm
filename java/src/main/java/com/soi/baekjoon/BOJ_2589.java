package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2589 {
    private static final int[][] dir = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    private static int r, c;
    private static boolean[][] map;

    public static void main(String[] args) throws IOException {
        init();
        int answer = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!map[i][j]) continue;
                answer = Math.max(answer, bfs(i, j));
            }
        }
        System.out.println(answer);
    }

    private static int bfs(int rr, int cc) {
        boolean[][] visit = new boolean[r][c];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{rr, cc, 0});
        visit[rr][cc] = true;
        int max = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            max = Math.max(max, cur[2]);
            for (int[] d : dir) {
                int r = cur[0] + d[0];
                int c = cur[1] + d[1];
                if (!inRange(r, c) || visit[r][c] || !map[r][c]) {
                    continue;
                }
                visit[r][c] = true;
                queue.offer(new int[]{r, c, cur[2] + 1});
            }
        }
        return max;
    }


    private static boolean inRange(int rr, int cc) {
        return rr >= 0 && rr < r && cc >= 0 && cc < c;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = line.charAt(j) == 'L';
            }
        }
//        System.out.println(Arrays.deepToString(map));
    }
}
