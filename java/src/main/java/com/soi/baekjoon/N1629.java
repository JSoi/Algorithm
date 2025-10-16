package com.soi.baekjoon;

import java.util.Scanner;
import java.util.StringTokenizer;

public class N1629 {
    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();
        StringTokenizer tok = new StringTokenizer(input, " ");
        long a = Long.parseLong(tok.nextToken());
        long b = Long.parseLong(tok.nextToken());
        long c = Long.parseLong(tok.nextToken());
//        long a = 2_147_483_647L;
//        long b = 2_147_483_647L;
//        long c = 2_147_483_647L;
        System.out.println(mod(a, b, c));
    }

    private static long mod(long val, long exp, long mod) {
        if (exp == 1) {
            return val % mod;
        }
        long ret = mod(val, exp / 2, mod);
        ret = (ret * ret) % mod;
        if ((exp % 2) == 1) {
            ret = (ret * val) % mod;
        }
        return ret % mod;
    }
}
