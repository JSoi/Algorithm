package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N16194 { // 10m
    public static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];
        StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i < arr.length; i++) {
            arr[i] = Integer.parseInt(tok.nextToken());
        }
        Arrays.fill(dp, INF);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = Math.min(dp[i], arr[i]);
            for (int j = i + 1; j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[j - i] + dp[i]);
            }
        }
        System.out.println(dp[n]);
    }
}
