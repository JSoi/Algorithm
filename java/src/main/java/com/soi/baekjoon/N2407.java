package com.soi.baekjoon;

import java.math.BigInteger;
import java.util.Scanner;

public class N2407 {
    private static BigInteger[] fact;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        fact = new BigInteger[Math.max(n, m) + 1];
        fact[0] = fact[1] = BigInteger.ONE;
        System.out.println(factorial(n).divide(factorial(m).multiply(factorial(n - m))));
    }

    private static BigInteger factorial(int n) {
        if (fact[n] != null) {
            return fact[n];
        }
        fact[n] = factorial(n - 1).multiply(BigInteger.valueOf(n));
        return fact[n];
    }
}
