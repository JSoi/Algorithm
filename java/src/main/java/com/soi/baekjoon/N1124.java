package com.soi.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class N1124 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int[] dp = new int[b + 1];
        Arrays.fill(dp, 1);
        dp[0] = dp[1] = 0;
        for (int i = 2; i <= b; i++) {
            for (int j = 1; i * j <= b; j++) {
                dp[i * j] = dp[i] + dp[j];
            }
        }
        int answer = 0;
        for (int i = a; i <= b; i++) {
            if (dp[dp[i]] == 1) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
