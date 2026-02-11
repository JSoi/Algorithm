package com.soi.baekjoon;

import java.io.*;

public class BOJ_15988 {
    private static final int INF = 1_000_000_009;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());
        int k = 1000000;
        long[] dp = new long[k + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= k; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % INF;
        }
        while (testCase-- > 0) {
            int input = Integer.parseInt(br.readLine());
            bw.append(String.valueOf(dp[input])).append('\n');
        }
        bw.flush();
    }
}
