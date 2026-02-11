package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13398 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer tok = new StringTokenizer(br.readLine(), " ");

        long[] arr = new long[n + 1];
        long[][] dp = new long[n + 1][2];
        long answer = Long.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(tok.nextToken());
            answer = Math.max(answer, arr[i]);
        }
        dp[1][0] = arr[1];

        for (int i = 2; i <= n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0] + arr[i], arr[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0]) + arr[i];
            answer = Math.max(answer, Math.max(dp[i][0], dp[i][1]));
        }
        System.out.println(answer);
    }
}
