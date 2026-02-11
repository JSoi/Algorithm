package com.soi.baekjoon;

import java.io.*;

public class BOJ_15990 {
    public static final int len = 100000;
    private static final int MOD = 1_000_000_009;
    public static long[][] dp = new long[len + 1][4];

    public static void main(String[] args) throws IOException {
        dp[1][1] = dp[2][2] = dp[3][3] = 1;
        for (int num = 3; num <= len; num++) {
            for (int i = 1; i <= 3; i++) {
                for (int j = 1; j <= 3; j++) {
                    if (i == j) continue;
                    dp[num][i] += dp[num - i][j];
                    dp[num][i] %= MOD;
                }
            }
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            bw.write(answer(n) + "\n");
        }
        bw.flush();
    }

    static long answer(int len) {
        return (dp[len][1] + dp[len][2] + dp[len][3]) % MOD;
    }
}
