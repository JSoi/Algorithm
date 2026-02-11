package com.soi.baekjoon;

import java.util.Scanner;

public class BOJ_2011 {
    private static final int DIV = 1000000;

    public static void main(String[] args) {
        String s = new Scanner(System.in).nextLine();
        int n = s.length();
        if (n == 1) {
            System.out.println(inRange(s) ? 1 : 0);
            return;
        }
        long[] dp = new long[n];

        dp[0] = s.charAt(0) == '0' ? 0 : 1;
        dp[1] = (inRange(s.substring(0, 2)) ? 1 : 0) + (inRange(s.charAt(1) + "") ? dp[0] : 0);
        for (int i = 2; i < n; i++) {
            String one = String.valueOf(s.charAt(i));
            String two = s.substring(i - 1, i + 1);
            if (!inRange(one) && !inRange(two)) {
                System.out.println(0);
                return;
            }
            if (inRange(one)) {
                dp[i] = (dp[i] + dp[i - 1]) % DIV;
            }
            if (inRange(two)) {
                dp[i] = (dp[i] + dp[i - 2]) % DIV;
            }
        }
        System.out.println(dp[n - 1]);
    }

    private static boolean inRange(String input) {
        int intValue = Integer.parseInt(input);
        if (input.length() == 1) {
            return intValue >= 1 && intValue <= 26;
        } else {
            return !input.startsWith("0") && intValue >= 1 && intValue <= 26;
        }
    }
}
