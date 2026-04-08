package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1086 {
    private static long[] lenPow;
    private static int n, k, max;
    private static long[][] dp;
    private static int[] rem;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[] inputs = new String[n];
        lenPow = new long[n];
        for (int i = 0; i < n; i++) {
            inputs[i] = br.readLine();
        }
        k = Integer.parseInt(br.readLine());
        rem = new int[n];
        for (int i = 0; i < n; i++) {
            String s = inputs[i];
            int len = s.length();
            lenPow[i] = powMod(len);
            long r = 0;
            for (char c : s.toCharArray()) {
                r = (r * 10 + (c - '0')) % k;
            }
            rem[i] = (int) r;
        }
        max = 1 << n;
        dp = new long[max][k];
        long fit = dp();
        long total = factorial(n);
        if (fit == 0) {
            System.out.println("0/1");
            return;
        }
        long gcd = gcd(total, fit);
        fit /= gcd;
        total /= gcd;
        System.out.println(fit + "/" + total);
    }

    private static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private static long dp() {
        dp[0][0] = 1;
        for (int status = 0; status < max; status++) {
            for (int remainder = 0; remainder < k; remainder++) {
                if (dp[status][remainder] == 0) continue;
                for (int next = 0; next < n; next++) {
                    if ((status & (1 << next)) != 0) continue;
                    int nextStatus = (1 << next) | status;
                    int nextRemainder = Math.toIntExact((remainder * lenPow[next] + rem[next]) % k);
                    dp[nextStatus][nextRemainder] += dp[status][remainder];
                }
            }
        }
        return dp[max - 1][0];
    }

    private static long factorial(int n) {
        if (n <= 1) return 1;
        return factorial(n - 1) * n;
    }

    private static long powMod(int digits) {
        long p = 1;
        for (int d = 0; d < digits; d++) p = p * 10 % k;
        return p;
    }
}

