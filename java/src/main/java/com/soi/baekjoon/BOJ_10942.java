package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10942 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        boolean[][] dp = new boolean[n + 1][n + 1];
        StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(tok.nextToken());
        }
        for (int i = 1; i <= n; i++) {
            dp[i][i] = true;
        }

        for (int i = 1; i < n; i++) {
            if (arr[i] == arr[i + 1]) {
                dp[i][i + 1] = true;
            }
        }
        for (int len = 3; len <= n; len++) {
            for (int s = 1; s <= n - len + 1; s++) {
                int e = s + len - 1;
                if (arr[s] == arr[e] && dp[s + 1][e - 1]) {
                    dp[s][e] = true;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int q = Integer.parseInt(br.readLine());
        for (int i = 1; i <= q; i++) {
            String[] question = br.readLine().split(" ");
            int from = Integer.parseInt(question[0]);
            int to = Integer.parseInt(question[1]);
            sb.append(dp[from][to] ? "1" : "0").append("\n");
        }
        System.out.print(sb);
    }
}
