package com.soi.baekjoon;

import java.util.Scanner;

public class BOJ_9656 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();


        scan.close();
        int count = (n / 3) + (n % 3);
        System.out.println(count % 2 == 1 ? "CY" : "SK");
    }

}
