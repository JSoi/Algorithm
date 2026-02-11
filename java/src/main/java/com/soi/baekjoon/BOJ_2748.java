package com.soi.baekjoon;

import java.util.Scanner;

public class BOJ_2748 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        scan.close();
        long[] dp = new long[input + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= input; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
//		System.out.println(Arrays.toString(dp));
        System.out.println(dp[input]);
    }

}
