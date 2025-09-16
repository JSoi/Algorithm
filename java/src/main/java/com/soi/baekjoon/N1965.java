package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1965 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int idx = 0;
        StringTokenizer tok = new StringTokenizer(br.readLine());
        int maxWeight = 0;
        while (tok.hasMoreTokens()) {
            int w = Integer.parseInt(tok.nextToken());
            arr[idx++] = w;
            maxWeight = Math.max(maxWeight, w);
        }

        int[] dp = new int[maxWeight + 1];

        int answer = 0;
        for (int i = 0; i < n; i++) {
            int weight = arr[i];
            dp[weight] = Math.max(dp[weight], 1);
            for (int j = 1; j < weight; j++) {
                dp[weight] = Math.max(dp[weight], dp[j] + 1);
            }
            answer = Math.max(answer, dp[weight]);
        }
        System.out.println(answer);
    }

}
