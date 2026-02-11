package com.soi.baekjoon;

import java.util.Scanner;

public class BOJ_10870_2 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        System.out.println(fibo(input));
    }

    static int fibo(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        return (fibo(n - 1) + fibo(n - 2));
    }
}
