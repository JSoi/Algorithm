package com.soi.baekjoon;

import java.util.Scanner;

public class M16953 {
    static long a, b;
    static int count;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        a = scan.nextLong();
        b = scan.nextLong();
        count = Integer.MAX_VALUE;
        solve(1, a);
        System.out.println(count == Integer.MAX_VALUE ? -1 : count);
    }

    static void solve(int nCount, long value) {
        if (value > b) {
            return;
        }
        if (value == b) {
            count = Math.min(count, nCount);
            return;
        } else {
            solve(nCount + 1, value * 2);
            long good = Long.parseLong(value + "1");
            solve(nCount + 1, good);
        }
    }
}
