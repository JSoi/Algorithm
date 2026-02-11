package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1535 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer lossTokens = new StringTokenizer(br.readLine(), " ");
        StringTokenizer joyTokens = new StringTokenizer(br.readLine(), " ");
        int[][] lossJoy = new int[N][2];
        for (int i = 0; i < N; i++) {
            lossJoy[i][0] = Integer.parseInt(lossTokens.nextToken());
            lossJoy[i][1] = Integer.parseInt(joyTokens.nextToken());
        }
        int[] dp = new int[101];
        for (int i = 0; i < N; i++) {
            int loss = lossJoy[i][0];
            int joy = lossJoy[i][1];
            for (int h = 99; h >= loss; h--) {
                dp[h] = Math.max(dp[h], dp[h - loss] + joy);
            }
        }
        System.out.println(Arrays.stream(dp).max().orElse(0));
    }
}
