package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N5557 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(tok.nextToken());
        }

        long[][] dp = new long[n][21];
        dp[0][arr[0]] = 1;
        for (int i = 1; i < n - 1; i++) {
            int offset = arr[i];
            for (int num = 0; num <= 20; num++) {
                if (inRange(num - offset)) {
                    dp[i][num] += dp[i - 1][num - offset];
                }
                if (inRange(num + offset)) {
                    dp[i][num] += dp[i - 1][num + offset];
                }
            }
        }
        System.out.println(dp[n - 2][arr[n - 1]]);
    }

    private static boolean inRange(int input) {
        return input >= 0 && input <= 20;
    }
}
