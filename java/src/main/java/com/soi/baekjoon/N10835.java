package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N10835 {
    private static int[][] dp;
    private static int[] left, right;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1][n + 1];
        left = new int[n];
        StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            left[i] = Integer.parseInt(tok.nextToken());
        }
        right = new int[n];
        tok = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            right[i] = Integer.parseInt(tok.nextToken());
        }
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        dp[0][0] = 0;
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= n; i++) {
            if (left[0] <= right[i - 1]) {
                break;
            }
            dp[0][i] = dp[0][i - 1] + right[i - 1];
        }
        for (int l = 1; l < n; l++) {
            for (int r = 1; r <= n; r++) {
                // 두 장 모두 버림
                int max = -1;
                if (left[l] > right[r - 1] && dp[l][r - 1] != -1) {
                    max = Math.max(max, dp[l][r - 1] + right[r - 1]);
                }
                max = Math.max(max, dp[l - 1][r - 1]);
                max = Math.max(max, dp[l - 1][r]);
                dp[l][r] = max;
            }
        }
//        System.out.println(Arrays.deepToString(dp));
        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, Math.max(dp[n - 1][i], dp[i][n]));
        }
        System.out.println(answer);
    }
}
