package com.soi.baekjoon;

import java.io.*;
import java.util.Arrays;

public class N9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseCount = Integer.parseInt(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (caseCount-- > 0) {
            int colCount = Integer.parseInt(br.readLine());
            int[][] sticker = new int[2][colCount];
            sticker[0] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            sticker[1] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int answer = dp(sticker);
            bw.append(answer + "\n");
        }
        bw.flush();
    }

    private static int dp(int[][] sticker) {
        int n = sticker[0].length;
        int[][] dp = new int[n][3];
        dp[0][1] = sticker[0][0];
        dp[0][2] = sticker[1][0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i - 1][2]));
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][2]) + sticker[0][i];
            dp[i][2] = Math.max(dp[i - 1][0], dp[i - 1][1]) +sticker[1][i];
        }
        return Math.max(dp[n - 1][0], Math.max(dp[n - 1][1], dp[n - 1][2]));
    }
}
