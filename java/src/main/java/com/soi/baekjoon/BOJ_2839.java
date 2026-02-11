package com.soi.baekjoon;

import java.util.Scanner;

public class BOJ_2839 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int weight = scan.nextInt();
        scan.close();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= weight / 5; i++) {
            if ((weight - 5 * i) % 3 == 0) {
                min = Math.min(i + (weight - 5 * i) / 3, min);
            }
        }
        min = min == Integer.MAX_VALUE ? -1 : min;
        System.out.println(min);
    }

}
