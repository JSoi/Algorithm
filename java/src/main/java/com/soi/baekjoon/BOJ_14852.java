package com.soi.baekjoon;

import java.util.Scanner;

public class BOJ_14852 {
    private static final long DIV = 1_000_000_007;

    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        long[] both = new long[n + 1];
        long[] upper = new long[n + 1];
        long[] lower = new long[n + 1];
        both[0] = upper[0] = lower[0] = 1;
        upper[1] = lower[1] = 1;
        both[1] = 2;
        for (int i = 2; i <= n; i++) {
            upper[i] = (both[i - 1] + lower[i - 1]) % DIV;
            lower[i] = (both[i - 1] + upper[i - 1]) % DIV;
            both[i] = (2 * both[i - 1] + lower[i - 1] + upper[i - 1] + both[i - 2]) % DIV;
        }
        System.out.println(both[n]);
    }
}
