package com.soi.programmers;

import java.util.Scanner;

public class POG_12934 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        long input = scan.nextLong();
        System.out.println(solution(input));
        scan.close();
    }

    public static long solution(long n) {
        long sqrt = (int) Math.sqrt(n);
        if (sqrt * sqrt != n)
            return -1;
        else
            return (sqrt + 1) * (sqrt + 1);
    }
}
