package com.soi.baekjoon;

import java.util.Scanner;

public class BOJ_1019 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        sc.close();
        long[] answer = new long[10];
        for (int i = 1; i < answer.length; i++) {
            answer[i] = count(n, i);
        }
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
    }

    static long count(long n, int targetN) {
        long count = 0;
        for (int i = 1; i < n; i *= 10) {
            long cur = n / i;
            long count1 = (cur / 10) + (cur % 10 >= targetN ? 1 : 0);
            count += count1;
        }
        return count;
    }
}
