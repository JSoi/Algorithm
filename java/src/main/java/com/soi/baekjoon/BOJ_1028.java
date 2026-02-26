package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1028 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[][][] dp = new int[r][c][2];
        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                if (line.charAt(j) == '0') continue;
                dp[i][j][0] = dp[i][j][1] = 1; // 북서방향, 북동방향
                if (i >= 1 && j >= 1)
                    dp[i][j][0] += dp[i - 1][j - 1][0];
                if (i >= 1 && j < c - 1)
                    dp[i][j][1] += dp[i - 1][j + 1][1];
            }
        }
        int answer = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int size = Math.min(dp[i][j][0], dp[i][j][1]);
                if (size <= 1) {
                    answer = Math.max(answer, size);
                    continue;
                }
                for (int k = size - 1; k > 0; k--) {
                    if (dp[i - k][j - k][1] >= k + 1 && dp[i - k][j + k][0] >= k + 1) {
                        answer = Math.max(answer, k + 1);
                        break;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
