package com.soi.baekjoon;

import java.util.Scanner;

public class BOJ_2869 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int v = scan.nextInt();
        scan.close();
        double sd = (double) v - a;
        System.out.println((int) Math.ceil(sd / (a - b)) + 1);
    }

}
