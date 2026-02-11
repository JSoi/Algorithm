package com.soi.baekjoon;

import java.util.Scanner;

public class BOJ_2753 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        scan.close();
        if ((input % 4 == 0 && input % 100 != 0) || (input % 400 == 0))
            System.out.println(1);
        else
            System.out.println(0);
    }
}
