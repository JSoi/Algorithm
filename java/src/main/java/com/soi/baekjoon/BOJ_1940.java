package com.soi.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1940 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[] ingred = new int[n];
        for (int i = 0; i < n; i++) {
            ingred[i] = scan.nextInt();
        }
        Arrays.sort(ingred);
        int start = 0, end = ingred.length - 1, sum = 0, count = 0;
        while (start < end) {
            sum = ingred[start] + ingred[end];
            if (sum == m) {
                count++;
                start++;
                end--;
            } else if (sum > m) {
                end--;
            } else {
                start++;
            }
        }
        System.out.println(count);
    }

}
