package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N1520 {
    static int row;
    static int col;
    static int[][] map;
    static int[][] dp;
    static final int[] dc = {0, 0, -1, 1};
    static final int[] dr = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fLine = br.readLine();
        row = Integer.parseInt(fLine.split(" ")[0]);
        col = Integer.parseInt(fLine.split(" ")[1]);
        map = new int[row][col];
        dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            int[] input = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < col; j++) {
                map[i][j] = input[j];
                dp[i][j] = -1;
            }
        }
        br.close();
        System.out.println(travel(0, 0));
    }

    static int travel(int r, int c) {
        if (r == row - 1 && c == col - 1) {
            return 1;
        }
        if (dp[r][c] != -1) {
            return dp[r][c];
        }
        dp[r][c] = 0;
        for (int m = 0; m < 4; m++) {
            int nextR = r + dr[m];
            int nextC = c + dc[m];
            if (nextC < 0 || nextC >= col || nextR < 0 || nextR >= row
                    || map[nextR][nextC] >= map[r][c]) {
                continue;
            }
            dp[r][c] += travel(nextR, nextC);
        }
        return dp[r][c];
    }
}
