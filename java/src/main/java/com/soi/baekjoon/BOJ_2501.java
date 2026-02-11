package com.soi.baekjoon;

import java.util.Scanner;

public class BOJ_2501 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        int count = scan.nextInt();
        scan.close();
        int miniCount = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                miniCount++;
                if (miniCount == count) {
                    System.out.println(i);
                    return;
                } else if (miniCount > count) {
                    System.out.println(0);
                    return;
                }
            }

        }
        System.out.println(0);
    }

}
