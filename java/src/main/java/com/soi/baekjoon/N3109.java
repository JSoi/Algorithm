package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class N3109 {
    private static int r, c, answer;
    private static boolean[][] wall;
    private static final int[][] movement = new int[][]{{1, 1}, {0, 1}, {-1, 1}};

    private static class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        wall = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                wall[i][j] = line.charAt(j) == 'x';
            }
        }

        for (int i = 0; i < r; i++) {
            if (!wall[i][0]) {
                dfs(i, 0);
            }
        }
        System.out.println(answer);
    }

    private static void dfs(int rr, int cc) {
        int[] track = new int[c];
        track[0] = rr;
        Stack<Point> stack = new Stack<>();
        boolean[][] visit = new boolean[r][c];
        stack.push(new Point(rr, cc));
        visit[rr][cc] = true;
        while (!stack.isEmpty()) {
            Point curr = stack.pop();
            if (curr.col == c - 1) {
                for (int i = 0; i < c; i++) {
                    wall[track[i]][i] = true;
                }
                answer++;
                return;
            }
            for (int[] m : movement) {
                int nR = curr.row + m[0];
                int nC = curr.col + m[1];
                if (!inRange(nR, nC) || visit[nR][nC] || wall[nR][nC]) continue;
                visit[nR][nC] = true;
                track[nC] = nR;
                stack.push(new Point(nR, nC));
            }
        }
    }

    private static boolean inRange(int i, int j) {
        return i >= 0 && i < r && j >= 0 && j < c;
    }
}
