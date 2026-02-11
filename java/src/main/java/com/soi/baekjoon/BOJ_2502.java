package com.soi.baekjoon;

import java.util.Scanner;

public class BOJ_2502 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int day = scanner.nextInt();
        int riceCakeCount = scanner.nextInt();
        int[][] dp = new int[day + 1][2];
        dp[1][0] = 1;
        dp[2][1] = 1;
        for (int i = 3; i <= day; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
            dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
        }
//        System.out.println(dp[day][0] + " " + dp[day][1]);
        for (int f = 1; f <= riceCakeCount; f++) {
            int s = (riceCakeCount - dp[day][0] * f) / dp[day][1];
            if (f * dp[day][0] + s * dp[day][1] == riceCakeCount) {
                System.out.println(f);
                System.out.println(s);
                return;
            }
        }
    }
}
