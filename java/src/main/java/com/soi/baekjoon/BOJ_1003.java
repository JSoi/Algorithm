package com.soi.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1003 {

    // BufferedReader, BufferedWriter

    public static void main(String[] args) throws NumberFormatException, IOException {

        int[][] dp = new int[41][2];
        dp[0][0] = 1;
        dp[1][1] = 1;
        for (int i = 2; i <= 40; i++) {
            dp[i][0] += (dp[i - 2][0] + dp[i - 1][0]);
            dp[i][1] += (dp[i - 2][1] + dp[i - 1][1]);
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer buf = new StringBuffer();
        int testCase = Integer.parseInt(br.readLine());
        for (int j = 0; j < testCase; j++) {
            int input = Integer.parseInt(br.readLine());
            buf.append(input + " ");
        }
        String str = buf.toString().trim();
        StringTokenizer tok = new StringTokenizer(str, " ");
        while (tok.hasMoreTokens()) {
            int target = Integer.parseInt(tok.nextToken());
            bw.append(dp[target][0] + " " + dp[target][1] + "\n");
        }
        bw.flush();
    }
}
