package com.soi.baekjoon;

import java.util.Scanner;

public class BOJ_1712 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        long a = scan.nextLong();
        long b = scan.nextLong();
        long c = scan.nextLong();
        scan.close();
        if (c - b <= 0)
            System.out.println(-1);
        else
            System.out.println((a / (c - b)) + 1);
    }

}
