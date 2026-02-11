package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2579 {
    static int[] arr;
    static int cnt;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        cnt = Integer.parseInt(buf.readLine());
        arr = new int[cnt + 1];
        dp = new int[cnt + 1];
        for (int i = 1; i <= cnt; i++) {
            arr[i] = Integer.parseInt(buf.readLine());
        }
        if (cnt == 1) {
            System.out.println(arr[1]);
            return;
        }
        dp[1] = arr[1];
        dp[2] = arr[2] + arr[1];
        for (int i = 3; i <= cnt; i++) {
            dp[i] = arr[i] + Math.max(dp[i - 2], arr[i - 1] + dp[i - 3]);
        }
        System.out.println(dp[cnt]);
    }
}