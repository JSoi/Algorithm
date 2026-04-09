package com.soi.baekjoon;

import java.util.Scanner;

public class BOJ_1436 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max = 10000666;
        int count = 0;
        for (int i = 1; i <= max; i++) {
            if (String.valueOf(i).contains("666")) {
                count++;
            }
            if (count == n) {
                System.out.println(i);
                return;
            }
        }
    }
}
