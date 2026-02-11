package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2342 {
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        // DP[current][left][right] = min(DP[before][left][right] + cost(before->current))
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tok = new StringTokenizer(br.readLine(), " ");

        ArrayList<Integer> moves = new ArrayList<>();
        while (true) {
            int m = Integer.parseInt(tok.nextToken());
            if (m == 0) {
                break;
            }
            moves.add(m);
        }
        int len = moves.size();
        int[][][] dp = new int[len + 1][5][5];
        for (int[][] dd : dp) {
            for (int[] d : dd) {
                Arrays.fill(d, INF);
            }
        }
        dp[0][0][0] = 0; // start state
        for (int i = 1; i <= len; i++) {
            int end = moves.get(i - 1);
            for (int r = 0; r <= 4; r++) {
                for (int l = 0; l <= 4; l++) {
                    if (dp[i - 1][l][r] == INF) {
                        continue;
                    }
                    if (end != r)
                        dp[i][end][r] = Math.min(dp[i][end][r], dp[i - 1][l][r] + cost(l, end)); // 왼발 움직임
                    if (end != l)
                        dp[i][l][end] = Math.min(dp[i][l][end], dp[i - 1][l][r] + cost(r, end)); // 오른발 움직임
                }
            }
//            System.out.println(Arrays.deepToString(dp[i]));
        }
        int answer = INF;
        for (int r = 0; r <= 4; r++) {
            for (int l = 0; l <= 4; l++) {
                answer = Math.min(answer, dp[len][l][r]);
            }
        }
        System.out.println(answer);
    }

    private static int cost(int from, int to) {
        if (from == 0) {
            return 2;
        }
        int diff = Math.abs(from - to);
        return switch (diff) {
            case 2 -> 4;
            case 0 -> 1;
            default -> 3;
        };
    }
}
