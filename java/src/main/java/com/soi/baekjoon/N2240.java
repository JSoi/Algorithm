package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N2240 {

    public static final int INVALID = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
        int T = Integer.parseInt(tok.nextToken());
        int W = Math.min(T, Integer.parseInt(tok.nextToken()));
        int[] cherry = new int[T + 1];
        for (int i = 1; i <= T; i++) {
            cherry[i] = Integer.parseInt(br.readLine());
        }

        // dp[time][move][pos] : time초까지, move번 이동해서 pos(1 or 2) 나무 아래에 있을 때 먹은 최대 자두
        int[][][] dp = new int[T + 1][W + 1][3];

        for (int t = 0; t <= T; t++) {
            for (int w = 0; w <= W; w++) {
                dp[t][w][1] = INVALID;
                dp[t][w][2] = INVALID;
            }
        }

        dp[0][0][1] = 0;

        for (int t = 1; t <= T; t++) {
            if (dp[t - 1][0][1] != INVALID) {
                dp[t][0][1] = dp[t - 1][0][1] + (cherry[t] == 1 ? 1 : 0);
            }
            for (int w = 1; w <= W; w++) {
                if (dp[t - 1][w - 1][2] != INVALID || dp[t - 1][w][1] != INVALID) {
                    dp[t][w][1] = Math.max(dp[t - 1][w - 1][2], dp[t - 1][w][1]) + (cherry[t] == 1 ? 1 : 0);
                }
                if (dp[t - 1][w - 1][1] != INVALID || dp[t - 1][w][2] != INVALID) {
                    dp[t][w][2] = Math.max(dp[t - 1][w - 1][1], dp[t - 1][w][2]) + (cherry[t] == 2 ? 1 : 0);
                }
            }
        }
        int answer = 0;
        for (int i = 0; i <= W; i++) {
            answer = Math.max(answer, Math.max(dp[T][i][1], dp[T][i][2]));
        }
        System.out.println(answer);
    }
}
