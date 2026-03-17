package com.soi.baekjoon;

import java.io.*;
import java.util.Arrays;

public class BOJ_10211 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            int[] dp = new int[n];
            dp[0] = arr[0];
            int answer = dp[0];
            for (int i = 1; i < n; i++) {
                dp[i] = Math.max(arr[i], dp[i - 1] + arr[i]);
                answer = Math.max(answer, dp[i]);
            }
            bw.write(answer + '\n');
        }
        bw.flush();
    }
}
