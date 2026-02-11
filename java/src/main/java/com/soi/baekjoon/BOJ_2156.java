package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseCount = Integer.parseInt(br.readLine());
        int[] wineArr = new int[caseCount];
        for (int w = 0; w < caseCount; w++) {
            wineArr[w] = Integer.parseInt(br.readLine());
        }
        System.out.println(wine(wineArr));
    }

    public static int wine(int[] wineArr) {
        int[][] dp = new int[wineArr.length][3];
        // 0 : 미포함
        // 1 : 현재 인덱스까지 길이 1
        // 2 : 현재 인덱스까지 길이 2
        if (wineArr.length < 2) {
            return Arrays.stream(wineArr).sum();
        }
        dp[0][1] = dp[1][0] = wineArr[0];
        dp[1][1] = wineArr[1];
        dp[1][2] = wineArr[0] + wineArr[1];

        for (int i = 2; i < wineArr.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i - 1][2]));
            dp[i][1] = wineArr[i] + dp[i - 1][0];
            dp[i][2] = dp[i - 1][1] + wineArr[i];
        }

        return Math.max(dp[dp.length - 1][0], Math.max(dp[dp.length - 1][1], dp[dp.length - 1][2]));
    }
}
