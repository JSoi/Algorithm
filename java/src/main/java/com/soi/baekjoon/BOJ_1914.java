package com.soi.baekjoon;

import java.math.BigInteger;
import java.util.Scanner;

public class BOJ_1914 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(BigInteger.valueOf(2).pow(n).subtract(BigInteger.ONE));
        if (n <= 20) {
            hanoi(n, 1, 2, 3);
        }
    }

    public static void hanoi(int n, int from, int via, int to) {
        if (n == 1) {
            System.out.println(from + " " + to);
            return;
        }
        hanoi(n - 1, from, to, via);
        System.out.println(from + " " + to);
        hanoi(n - 1, via, from, to);
    }
}
