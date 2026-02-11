package com.soi.baekjoon;

import java.util.Scanner;

public class BOJ_2018 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        long n = scan.nextLong();
        int start = 1, end = 1, count = 1, sum = 1;
        while (end != n) {
            if (sum == n) {
                count++;
                end++;
                sum += end;
            } else if (sum > n) {
                sum -= start;
                start++;
            } else {
                end++;
                sum += end;
            }
        }
        System.out.println(count);
    }

}
