package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11060 {
    public static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(tok.nextToken());
        }
        int[] dp = new int[n];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 0 || dp[i] == INF) continue;
            for (int j = i + 1; j <= i + arr[i] && j < n; j++) {
                dp[j] = Math.min(dp[j], dp[i] + 1);
            }
        }
        System.out.println(dp[n - 1] == INF ? -1 : dp[n - 1]);
    }
}
