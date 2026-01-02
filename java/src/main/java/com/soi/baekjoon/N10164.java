package com.soi.baekjoon;

import java.util.Scanner;

public class N10164 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int r = scanner.nextInt();
        int c = scanner.nextInt();
        int k = scanner.nextInt();
        int targetR = (k - 1) / c;
        int targetC = (k - 1) % c;
        int[][][] dp = new int[r][c][2];
        if (k > 0) {
            if (targetR == 0 && targetC == 0) {
                dp[0][0][1] = 1;
            } else {
                dp[0][0][0] = 1;
            }
        } else {
            dp[0][0][0] = 1;
        }

        for (int i = 1; i < r; i++) {
            dp[i][0][1] += dp[i - 1][0][1];
            if (i == targetR && targetC == 0) {
                dp[i][0][1] += dp[i - 1][0][0];
                continue;
            }
            dp[i][0][0] += dp[i - 1][0][0];
        }
        for (int i = 1; i < c; i++) {
            dp[0][i][1] += dp[0][i - 1][1];
            if (i == targetC && targetR == 0) {
                dp[0][i][1] += dp[0][i - 1][0];
                continue;
            }
            dp[0][i][0] += dp[0][i - 1][0];
        }
        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                // up
                if (i == targetR && j == targetC) {
                    dp[i][j][1] += dp[i - 1][j][0] + dp[i][j - 1][0];
                } else {
                    dp[i][j][0] += dp[i - 1][j][0] + dp[i][j - 1][0];
                    dp[i][j][1] += dp[i - 1][j][1] + dp[i][j - 1][1];
                }
            }
        }
        System.out.println(dp[r - 1][c - 1][k == 0 ? 0 : 1]);
    }
}
