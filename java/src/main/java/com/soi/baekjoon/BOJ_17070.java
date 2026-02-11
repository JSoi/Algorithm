package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * <a href = "https://www.acmicpc.net/problem/17070">파이프 옮기기 1</a>
 */
public class BOJ_17070 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[][] canPass = new boolean[N][N]; // N = [3,6]
        int[][][] dp = new int[N][N][3]; // 끝점 기준이며 0 - 가로 파이프, 1 - 세로 파이프, 2 - 대각선 파이프
        for (int r = 0; r < N; r++) {
            StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
            for (int c = 0; c < N; c++) {
                canPass[r][c] = tok.nextToken().equals("0");
            }
        }
        dp[0][1][0] = 1;
        for (int c = 1; c < N; c++) {
            if (!canPass[0][c]) {
                break;
            }
            dp[0][c][0] += dp[0][c - 1][0];
        }
        for (int r = 1; r < N; r++) {
            for (int c = 1; c < N; c++) {
                if (!canPass[r][c]) {
                    continue;
                }
                // 가로
                dp[r][c][0] += dp[r][c - 1][0] + dp[r][c - 1][2];
                // 세로
                dp[r][c][1] += dp[r - 1][c][1] + dp[r - 1][c][2];
                // 대각선
                dp[r][c][2] += (canPass[r - 1][c] && canPass[r][c - 1]) ? dp[r - 1][c - 1][0] + dp[r - 1][c - 1][1] + dp[r - 1][c - 1][2] : 0;
            }
        }
        System.out.println(dp[N - 1][N - 1][0] + dp[N - 1][N - 1][1] + dp[N - 1][N - 1][2]);
    }
}
