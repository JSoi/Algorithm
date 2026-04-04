package com.soi.baekjoon;

import java.util.Scanner;

public class BOJ_1789 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Long n = scan.nextLong();
        if (n == 1) {
            System.out.println(1);
            return;
        }
        long counter = (long) Math.sqrt(2 * n);
        while (true) {
            long counterSum = (counter + 1) * counter / 2;
            long leftOver = n - counterSum;
            if (leftOver > counter) {
                System.out.println(counter + 1);
                return;
            }
            counter--;
        }
    }
}
