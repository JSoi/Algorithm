package com.soi.baekjoon;

import java.util.Scanner;

public class BOJ_14606 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        scan.close();
        if (input == 1) {
            System.out.println(0);
            return;
        }
        int[] dp = new int[input + 1];
        dp[0] = dp[1] = 0;
        dp[2] = 1;
        for (int i = 3; i <= input; i++) {
            int v = 0;
            for (int j = 1; j <= i / 2; j++) {
                v = Math.max(v, j * (i - j) + dp[j] + dp[i - j]);
            }
            dp[i] = v;
        }
        System.out.println(dp[input]);
    }
}
