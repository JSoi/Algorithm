package com.soi.baekjoon;

import java.util.Scanner;

public class BOJ_1309 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] zero = new int[n]; // 00
        int[] one = new int[n]; // 01
        int[] two = new int[n]; // 10
        zero[0] = one[0] = two[0] = 1;
        for (int i = 1; i < n; i++) {
            zero[i] = (zero[i - 1] + one[i - 1] + two[i - 1]) % 9901;
            one[i] = (zero[i - 1] + two[i - 1]) % 9901;
            two[i] = (zero[i - 1] + one[i - 1]) % 9901;
        }
        int answer = (zero[n - 1] + one[n - 1] + two[n - 1]) % 9901;
        System.out.println(answer);
    }
}
