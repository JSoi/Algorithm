package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1679 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int givenGameNum = Integer.parseInt(br.readLine());
        StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
        int k = Integer.parseInt(br.readLine());
        int[] nums = new int[givenGameNum];
        for (int i = 0; i < givenGameNum; i++) {
            nums[i] = Integer.parseInt(tok.nextToken());
        }
        final int MAX = nums[nums.length - 1] * k + 1;
        int[] dp = new int[MAX + 1];
        Arrays.fill(dp, MAX);
        dp[0] = 0;
        for (int num : nums) {
            dp[num] = 1;
            for (int j = num + 1; j <= MAX; j++) {
                dp[j] = Math.min(dp[j], dp[j - num] + dp[num]);
            }
        }
        for (int i = 1; i <= MAX; i++) {
            if (dp[i] > k) {
                System.out.println((i % 2 == 0 ? "holsoon" : "jjaksoon") + " win at " + i);
                return;
            }
        }
    }
}


