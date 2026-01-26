package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N17069 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] wall = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                wall[i][j] = st.nextToken().equals("1");
            }
        }
        long[][][] dp = new long[n][n][3]; // [가로, 세로, 대각선]
        dp[0][1][0] = 1;

        for (int j = 2; j < n; j++) {
            if (wall[0][j]) break;
            dp[0][j][0] = dp[0][j - 1][0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (wall[i][j]) continue;
                // 가로
                dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][2];
                // 세로
                dp[i][j][1] = dp[i - 1][j][1] + dp[i - 1][j][2];
                // 대각선
                if (!wall[i - 1][j] && !wall[i][j - 1]) {
                    dp[i][j][2] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
                }
            }
        }
        System.out.println(dp[n - 1][n - 1][0] + dp[n - 1][n - 1][1] + dp[n - 1][n - 1][2]);
    }
}
