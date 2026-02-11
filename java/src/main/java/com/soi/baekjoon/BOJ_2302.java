package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int vipCount = Integer.parseInt(br.readLine());

        int[] vipArr = new int[vipCount];
        long[] dp = new long[n + 1];

        for (int i = 0; i < vipCount; i++) {
            vipArr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(vipArr);

        if (n == 1) {
            System.out.println(1);
            return;
        }

        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        long answer = 1;
        int vipValue = 0;
        int len;
        for (int i = 0; i < vipCount; i++) {
            len = vipArr[i] - vipValue - 1;
            answer *= dp[len];
            vipValue = vipArr[i];
        }
        len = n - vipValue;
        answer *= dp[len];
        System.out.println(answer);
    }
}
