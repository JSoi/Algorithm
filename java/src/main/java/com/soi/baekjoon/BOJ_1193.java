package com.soi.baekjoon;

import java.util.Scanner;

public class BOJ_1193 {
    public static void main(String[] args) {

        // 11- 12 -21 -31- 22-
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        for (int i = 0; i < 10000; i++) {
            int val = i * (i - 1) / 2;
            if (val < input && ((i + 1) * i / 2) >= input) {
                if (i % 2 == 0) {
                    System.out.println((input - val) + "/" + (i + 1 - input + val));
                } else {
                    System.out.println((i + 1 - input + val) + "/" + (input - val));
                }
                break;
            }
        }
        scan.close();
    }

}
