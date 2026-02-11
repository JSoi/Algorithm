package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1189 {
    private final static int[][] move = new int[][]{{0, -1, 0, 1}, {1, 0, -1, 0}}; // 이동 경로 배열
    private static int answer = 0;
    private static int distance;
    private static boolean[][] map; // 이동 경로 배열

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstLine = reader.readLine();
        StringTokenizer stk = new StringTokenizer(firstLine, " ");
        int ver = Integer.parseInt(stk.nextToken());
        int hor = Integer.parseInt(stk.nextToken());
        distance = Integer.parseInt(stk.nextToken());
        map = new boolean[ver][hor]; // 장애물을 포함한 배열
        boolean[][] visit = new boolean[ver][hor]; // 방문 배열
        for (int i = 0; i < ver; i++) {
            String line = reader.readLine();
            for (int j = 0; j < hor; j++) {
                map[i][j] = line.charAt(j) != 'T';
            }
        }
        visit[ver - 1][0] = true;
        visit(ver - 1, 0, visit, 1);
        System.out.println(answer);
    }

    private static void visit(int v, int h, boolean[][] visit, int travelDistance) {
        if (travelDistance == distance) {
            if ((v == 0) && (h == (visit[0].length - 1))) {
                answer++;
            }
            return;
        }
        for (int k = 0; k < 4; k++) {
            int nextV = v + move[0][k];
            int nextH = h + move[1][k];
            if (nextV < 0 || nextH < 0 || nextV >= map.length || nextH >= map[0].length) {
                continue;
            }
            if (!visit[nextV][nextH] && map[nextV][nextH]) {
                visit[nextV][nextH] = true;
                visit(nextV, nextH, visit, travelDistance + 1);
                visit[nextV][nextH] = false;
            }
        }
    }
}
