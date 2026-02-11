package com.soi.baekjoon;

import java.util.Scanner;

public class BOJ_5554 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        int d = scan.nextInt();
        scan.close();
        int timeall = a + b + c + d;
        System.out.println(timeall / 60);
        System.out.println(timeall % 60);
    }

}
