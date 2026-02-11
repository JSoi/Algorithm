package com.soi.baekjoon;

import java.io.*;
import java.util.Arrays;

public class BOJ_4811 {
    private static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;
        dp = new long[31][32];
        Arrays.fill(dp[0], 1);
        dp[0][0] = 0;
        for (int w = 1; w <= 30; w++) {
            dp[w][0] = dp[w - 1][1];
            for (int h = 1; h <= 30; h++) {
                dp[w][h] = dp[w - 1][h + 1] + dp[w][h - 1];
            }
        }
        while (!(input = br.readLine()).equals("0")) {
            int n = Integer.parseInt(input);
            bw.append(String.valueOf(dp[n][0])).append('\n');
        }
        bw.flush();
    }
}
