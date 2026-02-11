package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14722 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        int[][][] dp = new int[n][n][3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 0) {
                    dp[i][j][0] = 1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;

                // 안 먹음
                for (int k = 0; k < 3; k++) {
                    if (i > 0) dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j][k]);
                    if (j > 0) dp[i][j][k] = Math.max(dp[i][j][k], dp[i][j - 1][k]);
                }

                int milk = arr[i][j];
                int prev = (milk + 2) % 3;

                // 먹는 경우
                if (i > 0 && dp[i - 1][j][prev] > 0)
                    dp[i][j][milk] = Math.max(dp[i][j][milk], dp[i - 1][j][prev] + 1);

                if (j > 0 && dp[i][j - 1][prev] > 0)
                    dp[i][j][milk] = Math.max(dp[i][j][milk], dp[i][j - 1][prev] + 1);
            }

        }
        System.out.println(Math.max(dp[n - 1][n - 1][0], Math.max(dp[n - 1][n - 1][1], dp[n - 1][n - 1][2])));
    }
}
