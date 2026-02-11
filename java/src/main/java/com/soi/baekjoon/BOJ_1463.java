package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1463 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        int[] dp = new int[input + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = dp[1] = 0;
        for (int i = 1; i <= input; i++) {
            if (i * 3 <= input) {
                dp[i * 3] = Math.min(dp[i * 3], dp[i] + 1);
            }
            if (i * 2 <= input) {
                dp[i * 2] = Math.min(dp[i * 2], dp[i] + 1);
            }
            if (i + 1 <= input) {
                dp[i + 1] = Math.min(dp[i + 1], dp[i] + 1);
            }
        }
        System.out.println(dp[input]);
    }

}
