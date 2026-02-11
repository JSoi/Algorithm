package com.soi.baekjoon;

import java.util.Scanner;

public class BOJ_10809 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        char[] inputC = input.toCharArray();
        int[] alpC = new int[26];
        for (int k = 0; k < alpC.length; k++) {
            alpC[k] = -1;
        }
        for (int i = 0; i < inputC.length; i++) {
            if (alpC[inputC[i] - 97] == -1) {
                alpC[inputC[i] - 97] = i;
            }
        }
        for (int j = 0; j < alpC.length; j++) {
            System.out.print(alpC[j] + " ");
        }
        scan.close();
    }
}
