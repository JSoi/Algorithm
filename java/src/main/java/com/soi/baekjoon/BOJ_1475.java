package com.soi.baekjoon;

import java.util.Scanner;

public class BOJ_1475 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int[] count = new int[10];
        for (int i = 0; i < line.length(); i++) {
            int num = line.charAt(i) - '0';
            count[num]++;
        }
        count[6] = (count[9] + count[6] + 1) / 2;
        count[9] = 0;
        int answer = 0;
        for (int i = 0; i < 10; i++) {
            answer = Math.max(answer, count[i]);
        }
        System.out.println(answer);
    }
}
