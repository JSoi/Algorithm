package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11052 {
    private static int[] card;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        card = new int[n + 1];
        StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            card[i] = Integer.parseInt(tok.nextToken());
        }
        System.out.println(find());
    }

    private static int find() {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = Math.max(dp[i], card[i]);
            for (int p = i; p <= n; p++) {
                dp[p] = Math.max(dp[p], dp[p - i] + dp[i]);
            }
        }
        return Math.max(dp[n], card[n]);
    }
}
