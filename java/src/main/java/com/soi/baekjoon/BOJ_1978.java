package com.soi.baekjoon;

import java.util.Scanner;

public class BOJ_1978 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int cs = scan.nextInt();
        int count = 0;
        for (int i = 0; i < cs; i++) {
            if (isPrime(scan.nextInt())) {
                count++;
            }
        }
        System.out.println(count);
    }

    static boolean isPrime(int input) {
        if (input < 2)
            return false;
        for (int k = 2; k * k <= input; k++) {
            if (input % k == 0) {
                return false;
            }
        }
        return true;
    }

}
