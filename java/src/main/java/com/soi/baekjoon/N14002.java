package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N14002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer tok = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int[] root = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(tok.nextToken());
            root[i] = i;
        }
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxLen = 0;
        int maxLenEndIdx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    root[i] = j;
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                maxLenEndIdx = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(arr[maxLenEndIdx]);
        while (root[maxLenEndIdx] != maxLenEndIdx) {
            maxLenEndIdx = root[maxLenEndIdx];
            sb.insert(0, arr[maxLenEndIdx] + " ");
        }
        System.out.println(maxLen);
        System.out.println(sb);
    }
}
