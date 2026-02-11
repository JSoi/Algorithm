package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1577 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int col = Integer.parseInt(line[0]);
        int row = Integer.parseInt(line[1]);
        boolean[][][] isHole = new boolean[row + 1][col + 1][2]; // 0 : 가로, 1 : 세로
        long[][] dp = new long[row + 1][col + 1];
        int holeCase = Integer.parseInt(br.readLine());
        for (int h = 0; h < holeCase; h++) {
            int[] holeArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            isHole[Math.min(holeArr[1], holeArr[3])][Math.min(holeArr[0], holeArr[2])][holeArr[0] == holeArr[2] ? 1 : 0] = true;
        }
        dp[0][0] = 1;
        for (int c = 1; c <= col && !isHole[0][c - 1][0]; c++) {
            dp[0][c] += dp[0][c - 1];
        }
        for (int r = 1; r <= row && !isHole[r - 1][0][1]; r++) {
            dp[r][0] += dp[r - 1][0];
        }
        for (int r = 1; r <= row; r++) {
            for (int c = 1; c <= col; c++) {
                // 위 -> 아래
                if (!isHole[r - 1][c][1]) {
                    dp[r][c] += dp[r - 1][c];
                }
                // 좌 -> 우
                if (!isHole[r][c - 1][0]) {
                    dp[r][c] += dp[r][c - 1];
                }
            }
        }
        System.out.println(dp[row][col]);
    }
}
