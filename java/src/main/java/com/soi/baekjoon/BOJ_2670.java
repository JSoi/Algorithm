package com.soi.baekjoon;

import java.util.Scanner;

public class BOJ_2670 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int count = scan.nextInt();
        double[] list = new double[count];
        for (int i = 0; i < count; i++) {
            list[i] = scan.nextDouble();
        }
        scan.close();
        for (int i = 1; i < count; i++) {
            list[i] = Math.max(list[i], list[i - 1] * list[i]);
        }
        double max = Double.MIN_VALUE;
        for (double d : list) {
            max = Math.max(max, d);
        }
        System.out.printf("%.3f%n", max);
    }

}
