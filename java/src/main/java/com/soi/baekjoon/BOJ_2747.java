package com.soi.baekjoon;

import java.util.Scanner;

public class BOJ_2747 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int target = scan.nextInt();
        if (target < 2) {
            System.out.println(target);
            return;
        }
        int[] fibo = new int[target + 1];
        fibo[1] = 1;
        fibo[2] = 1;
        for (int i = 2; i <= target; i++) {
            fibo[i] = fibo[i - 1] + fibo[i - 2];
        }
        System.out.println(fibo[target]);
    }
}
