package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11049 {
    public static final int MAX = Integer.MAX_VALUE;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        // dp 정의 : [from][to]
        dp = new int[n][n];
        for (int[] d : dp) {
            Arrays.fill(d, MAX);
        }
        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
        }
        // dp[i][j] = min(dp[i][j], dp[i][k] + dp[k+1][j] + cost)
        for (int len = 2; len <= n; len++) {
            for (int start = 0; start < n - len + 1; start++) {
                int end = start + len - 1;
                for (int k = start; k < end; k++) {
                    dp[start][end] = Math.min(dp[start][end], dp[start][k] + dp[k + 1][end] + arr[start][0] * arr[k][1] * arr[end][1]);
                }
            }
        }
//        System.out.println(Arrays.deepToString(dp));
        System.out.println(dp[0][n - 1]);
    }
}
