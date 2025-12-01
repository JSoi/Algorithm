package com.soi.baekjoon;

import java.io.*;

public class N15989 {
    public static final int len = 10_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());
        long[] dp = new long[len + 1];
        dp[0] = 1;
        for (int num = 1; num <= 3; num++) {
            for (int i = num; i <= len; i++) {
                dp[i] += dp[i - num];
            }
        }
        while (testCase-- > 0) {
            int n = Integer.parseInt(br.readLine());
            bw.write(dp[n] + "\n");
        }
        bw.flush();
    }
}
