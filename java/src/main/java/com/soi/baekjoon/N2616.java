package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N2616 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int len = Integer.parseInt(br.readLine());
        if (len == 1) {
            Arrays.sort(arr);
            int res = 0;
            for (int i = n - 1; i >= n - 3; i--) {
                res += arr[i];
            }
            System.out.println(res);
            return;
        }
        int[][] dp = new int[n][4];
        int sum = 0;
        int[] sums = new int[n];
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (i >= len - 1) {
                sums[i] = sum;
                sum -= arr[i - len + 1];
            }
        }
//        System.out.println(Arrays.toString(sums));
        for (int i = 1; i < n; i++) {
            dp[i][1] = Math.max(dp[i - 1][1], sums[i]);
        }
        for (int c = 2; c <= 3; c++) {
            for (int j = 1; j < n; j++) {
                dp[j][c] = dp[j - 1][c];
                if (j - len < 0) continue;
                dp[j][c] = Math.max(dp[j][c], dp[j - len][c - 1] + sums[j]);
            }
        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, dp[i][3]);
        }
        System.out.println(answer);
    }
}
