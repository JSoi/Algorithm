package com.soi.baekjoon;

import java.util.Scanner;

public class BOJ_5565 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int price = scan.nextInt();
        for (int i = 0; i < 9; i++) {
            int temp = scan.nextInt();
            price -= temp;
        }
        scan.close();
        System.out.println(price);
    }

}
