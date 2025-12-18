package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N2169 {
    public static final int IMP = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
        int r = Integer.parseInt(tok.nextToken());
        int c = Integer.parseInt(tok.nextToken());
        int[][] arr = new int[r + 1][c + 1];
        int[][][] dp = new int[r + 2][c + 2][2];
        for (int i = 1; i <= r; i++) {
            tok = new StringTokenizer(br.readLine());
            for (int j = 1; j <= c; j++) {
                arr[i][j] = Integer.parseInt(tok.nextToken());
            }
        }
        for (int i = 0; i < r + 2; i++) {
            for (int j = 0; j < c + 2; j++) {
                dp[i][j][0] = dp[i][j][1] = IMP;
            }
        }
        // 첫 번째 초기화
        dp[1][1][0] = arr[1][1];
        for (int i = 2; i <= c; i++) {
            dp[1][i][0] = dp[1][i - 1][0] + arr[1][i];
        }
        for (int i = 2; i <= r; i++) {
            // (l -> r) 채우기
            for (int j = 1; j <= c; j++) {
                dp[i][j][0] = Math.max(Math.max(dp[i - 1][j][0], dp[i - 1][j][1]), Math.max(dp[i][j - 1][0], dp[i][j - 1][1])) + arr[i][j];
            }
            // (r -> l) 채우기
            for (int j = c; j >= 1; j--) {
                dp[i][j][1] = Math.max(Math.max(dp[i - 1][j][0], dp[i - 1][j][1]), Math.max(dp[i][j + 1][1], dp[i][j + 1][1])) + arr[i][j];
            }
        }
        System.out.println(Math.max(dp[r][c][0], dp[r][c][1]));
    }
}
