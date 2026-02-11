package com.soi.baekjoon;

import java.util.Scanner;

public class BOJ_14501_2 {

    static int[] time;
    static int[] cost;
    static Integer[] dp;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int cnt = scan.nextInt();
        time = new int[cnt];
        cost = new int[cnt];
        dp = new Integer[cnt];
        for (int i = 0; i < cnt; i++) {
            time[i] = scan.nextInt();
            cost[i] = scan.nextInt();
        }
        dp(0);
        int max = 0;
        for (int i : dp) {
            max = Math.max(max, i);
        }
        System.out.println(max);
    }

    static int dp(int index) {
        if (index > time.length) {
            return 0;
        }
        if (dp[index] == null) {
            dp[index] = cost[index] + dp(index + time[index]);
        }
        return dp[index];
    }

}
