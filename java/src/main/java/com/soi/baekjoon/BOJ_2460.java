package com.soi.baekjoon;

import java.util.Scanner;

public class BOJ_2460 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int[] in = new int[10];
        int[] out = new int[10];
        for (int i = 0; i < 10; i++) {
            out[i] = scan.nextInt();
            in[i] = scan.nextInt();
        }
        int max = 0;
        int now = in[0];
        for (int i = 1; i < 10; i++) {
            now += in[i] - out[i];
            max = Math.max(max, now);
        }
        System.out.println(max);
    }

}
