package com.soi.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2629 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] weight = new int[N + 1];
        StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            weight[i] = Integer.parseInt(tok.nextToken());
        }

        boolean[][] dp = new boolean[N + 1][40001]; // 차이를 열로 지정
        dp[0][0] = true;
        for (int i = 1; i <= N; i++) {
            int w = weight[i];
            for (int d = 0; d <= 40000; d++) {
                if (dp[i - 1][d]) {
                    dp[i][d] = dp[i][Math.abs(d - w)] = true;
                    if (d + w <= 40000) {
                        dp[i][d + w] = true;
                    }
                }
            }
        }

        int cases = Integer.parseInt(br.readLine());
        tok = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < cases; i++) {
            int c = Integer.parseInt(tok.nextToken());
            boolean doesMatch = false;
            for (int j = 1; j <= N; j++) {
                doesMatch |= dp[j][c];
            }
            bw.write((doesMatch ? "Y" : "N") + " ");
        }
        bw.flush();
    }
}
