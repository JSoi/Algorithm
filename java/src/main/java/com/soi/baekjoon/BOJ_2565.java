package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ_2565 {
    private static int n;
    private static int[] dp;
    private static int[][] lines;
    private static BufferedReader br;

    public static void main(String[] args) throws IOException {
        init();
        dp = new int[n]; // I까지 교차하지 않는 전기줄 수
        Arrays.fill(dp, 1);
        int len = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (lines[j][1] < lines[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            len = Math.max(len, dp[i]);
        }

        System.out.println(n - len);
    }

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        lines = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            lines[i][0] = Integer.parseInt(line[0]);
            lines[i][1] = Integer.parseInt(line[1]);
        }
        Arrays.sort(lines, Comparator.comparingInt(a -> a[0]));
    }
}
