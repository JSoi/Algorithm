package com.soi.baekjoon;

import java.util.Scanner;

public class N31403 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        System.out.println(a + b - c);
        System.out.println(Integer.parseInt(a + String.valueOf(b)) - c);
    }
}
