package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_21736 {
    private static final int[][] pos = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static int r, c;
    private static char[][] map;
    private static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        visit = new boolean[r][c];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'I') { // 도연이 위치
                    queue.offer(new int[]{i, j});
                    visit[i][j] = true;
                }
            }
        }

        int answer = 0;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int rr = curr[0];
            int cc = curr[1];
            if (map[rr][cc] == 'P') {
                answer++;
            }
            for (int[] p : pos) {
                int nextRr = p[0] + rr;
                int nextCc = p[1] + cc;
                if (!inRange(nextRr, nextCc) || visit[nextRr][nextCc] || map[nextRr][nextCc] == 'X') {
                    continue;
                }
                queue.offer(new int[]{nextRr, nextCc});
                visit[nextRr][nextCc] = true;
            }
        }
        System.out.println(answer == 0 ? "TT" : answer);

    }

    private static boolean inRange(int rr, int cc) {
        return rr >= 0 && rr < r && cc >= 0 && cc < c;
    }
}
