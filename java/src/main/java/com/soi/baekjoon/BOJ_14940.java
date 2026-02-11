package com.soi.baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14940 {
    private static final int[][] mv = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
        int row = Integer.parseInt(tok.nextToken());
        int col = Integer.parseInt(tok.nextToken());
        int startR = 0, startC = 0;
        boolean[][] road = new boolean[row][col];
        boolean[][] originalRoad = new boolean[row][col];
        int[][] roadCost = new int[row][col];
        for (int[] rc : roadCost) {
            Arrays.fill(rc, -1);
        }
        for (int i = 0; i < row; i++) {
            tok = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < col; j++) {
                String r = tok.nextToken();
                if (r.equals("2")) {
                    startR = i;
                    startC = j;
                }
                road[i][j] = r.equals("1");

            }
        }
        for (int i = 0; i < originalRoad.length; i++) {
            originalRoad[i] = Arrays.copyOf(road[i], originalRoad[i].length);
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startR, startC, 0});
        roadCost[startR][startC] = 0;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int[] m : mv) {
                int nR = curr[0] + m[0];
                int nC = curr[1] + m[1];
                if (nR < 0 || nR >= row || nC < 0 || nC >= col || !road[nR][nC]) {
                    continue;
                }
                road[nR][nC] = false;
                roadCost[nR][nC] = curr[2] + 1;
                queue.offer(new int[]{nR, nC, curr[2] + 1});
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int value = 0;
                if (originalRoad[i][j]) {
                    value = roadCost[i][j];
                }
                bw.append(value + " ");
            }
            bw.append("\n");
        }
        bw.flush();
    }
}
