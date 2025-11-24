package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N17404 {
    private static final int INF = 100_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] cost = new int[n][3]; // RGB 비용
        for (int i = 0; i < n; i++) {
            StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
            cost[i][0] = Integer.parseInt(tok.nextToken());
            cost[i][1] = Integer.parseInt(tok.nextToken());
            cost[i][2] = Integer.parseInt(tok.nextToken());
        }

        // dp[i][currentColor][firstColor]
        int[][][] dp = new int[n][3][3];

        // 초기화
        for (int first = 0; first < 3; first++) {
            for (int c = 0; c < 3; c++) {
                if (c == first) dp[0][c][first] = cost[0][c];
                else dp[0][c][first] = INF;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int first = 0; first < 3; first++) {
                dp[i][0][first] =
                        Math.min(dp[i - 1][1][first], dp[i - 1][2][first]) + cost[i][0];
                dp[i][1][first] =
                        Math.min(dp[i - 1][0][first], dp[i - 1][2][first]) + cost[i][1];
                dp[i][2][first] =
                        Math.min(dp[i - 1][0][first], dp[i - 1][1][first]) + cost[i][2];
            }
        }

        int answer = INF;
        for (int first = 0; first < 3; first++) {
            for (int last = 0; last < 3; last++) {
                if (last != first) {
                    answer = Math.min(answer, dp[n - 1][last][first]);
                }
            }
        }

        System.out.println(answer);

    }
}
