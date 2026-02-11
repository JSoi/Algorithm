package com.soi.baekjoon;

import java.util.Scanner;

public class BOJ_2864 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        int minA = Integer.parseInt(str[0].replace("6", "5"));
        int maxA = Integer.parseInt(str[0].replace("5", "6"));

        int minB = Integer.parseInt(str[1].replace("6", "5"));
        int maxB = Integer.parseInt(str[1].replace("5", "6"));
        System.out.println((minA + minB) + " " + (maxA + maxB));
    }
}
