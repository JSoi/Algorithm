package com.soi.baekjoon;

import java.util.Scanner;

public class BOJ_10818 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int time = scan.nextInt();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int t = 0; t < time; t++) {
            int newone = scan.nextInt();
            if (newone <= min) min = newone;
            if (newone >= max) max = newone;
        }
        scan.close();
        System.out.println(min + " " + max);
    }

}
