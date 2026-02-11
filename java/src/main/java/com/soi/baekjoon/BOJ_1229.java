package com.soi.baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_1229 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        List<Integer> hexNumbers = hex(n);
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int hex : hexNumbers) {
                if (hex > i) {
                    break;
                }
                dp[i] = Math.min(dp[i], dp[i - hex] + 1);
            }
        }
        System.out.println(dp[n]);
    }

    private static List<Integer> hex(int max) {
        List<Integer> hexNumbers = new ArrayList<>();
        int hex = 1;
        int index = 1;
        while (hex <= max) {
            hexNumbers.add(hex);
            index++;
            hex += 4 * (index - 1) + 1;
        }
        return hexNumbers;
    }
}
