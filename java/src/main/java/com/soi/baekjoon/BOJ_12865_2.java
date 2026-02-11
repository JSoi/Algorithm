package com.soi.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_12865_2 {
    static final int MAX = 10000000;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = scan.nextInt();
        int weight = scan.nextInt();
        int[] dp = new int[weight + 1];
        Arrays.fill(dp, MAX);
        dp[0] = 0;
        for (int i = 1; i < count + 1; i++) {
            int w = scan.nextInt(); // weight
            int v = scan.nextInt(); // value
            for (int ww = w; ww <= weight; ww++) {
                dp[ww] = Math.min(dp[ww], dp[ww - w] + v);
            }
        }
        System.out.println(dp[weight]);
    }
}
