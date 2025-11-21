package com.soi.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class N11066 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int[][] dp = new int[n][n];
            int[] sum = new int[n + 1];

            // 누적합 저장
            for (int i = 0; i < n; i++) {
                sum[i + 1] = sum[i] + arr[i];
            }

            // dp[i][j] = min(dp[i][k] + dp[k+1][j] + sum(i,j))
            for (int len = 2; len <= n; len++) {
                for (int start = 0; start + len - 1 < n; start++) {
                    int end = start + len - 1;
                    dp[start][end] = Integer.MAX_VALUE;

                    int lastSum = sum[end + 1] - sum[start]; // 마지막 합
                    for (int k = start; k < end; k++) {
                        dp[start][end] = Math.min(
                                dp[start][end],
                                dp[start][k] + dp[k + 1][end] + lastSum
                        );
                    }
                }
            }
            bw.append(String.valueOf(dp[0][n - 1])).append("\n");
        }
        bw.flush();
    }
}
