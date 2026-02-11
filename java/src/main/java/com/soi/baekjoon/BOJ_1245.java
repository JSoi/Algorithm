package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_1245 {
    static final int[][] movement = new int[][]{{-1, -1}, {-1, 0}, {0, -1}, {0, 1}, {1, 0}, {1, 1}, {1, -1}, {-1, 1}};
    static boolean[][] visited;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int row = Integer.parseInt(input[0]);
        int col = Integer.parseInt(input[1]);
        map = new int[row][col];
        visited = new boolean[row][col];
        for (int r = 0; r < row; r++) {
            StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
            int c = 0;
            while (tok.hasMoreTokens()) {
                map[r][c++] = Integer.parseInt(tok.nextToken());
            }
        }
        int peakCount = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!visited[i][j] && isPeak(i, j)) {
                    peakCount++;
                }
            }
        }
        System.out.println(peakCount);
    }

    static boolean isPeak(int r, int c) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{r, c});
        visited[r][c] = true;
        int height = map[r][c];
        boolean isPeak = true;
        while (!stack.isEmpty()) {
            int[] cur = stack.pop();
            for (int[] move : movement) {
                int nR = cur[0] + move[0];
                int nC = cur[1] + move[1];
                if (nR >= 0 && nR < map.length && nC >= 0 && nC < map[0].length) {
                    if (map[nR][nC] > height) {
                        return false;
                    }
                    if (!visited[nR][nC] && map[nR][nC] == height) {
                        visited[nR][nC] = true;
                        stack.push(new int[]{nR, nC});
                    }
                }
            }
        }
        return isPeak;
    }
}
