package com.soi.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class N9084 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] coins = new int[n];
            StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                coins[j] = Integer.parseInt(tok.nextToken());
            }
            int money = Integer.parseInt(br.readLine());
            long[] dp = new long[money + 1];
            dp[0] = 1;
            for (int c : coins) {
                for (int cc = c; cc <= money; cc++) {
                    dp[cc] += dp[cc - c];
                }
            }
            bw.write(dp[money] + "\n");
        }
        bw.flush();
    }
}
