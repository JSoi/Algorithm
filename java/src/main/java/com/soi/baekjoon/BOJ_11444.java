package com.soi.baekjoon;

import java.math.BigInteger;
import java.util.Scanner;

public class BOJ_11444 {
    private static final long MOD = 1_000_000_007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger n = sc.nextBigInteger();
        System.out.println(fibonacci(n)[0]);
    }

    // F(2k) = F(k) * (2*F(k+1) − F(k))
    // F(2k+1) = F(k+1)^2 + F(k)^2
    private static long[] fibonacci(BigInteger n) { // [F(k), F(k+1)]
        if (n.signum() == 0) return new long[]{0, 1};

        long[] p = fibonacci(n.shiftRight(1));
        long a = p[0], b = p[1];

        long c = (a * ((2 * b - a + MOD) % MOD)) % MOD;
        long d = (a * a % MOD + b * b % MOD) % MOD;

        return n.testBit(0) ? new long[]{d, (c + d) % MOD}
                : new long[]{c, d};
    }
}
