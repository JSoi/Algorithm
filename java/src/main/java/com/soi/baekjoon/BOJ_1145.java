package com.soi.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1145 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int answer = 1;
        while (true) {
            int count = 0;
            for (int j : arr) {
                if (answer % j == 0) {
                    count++;
                }
            }
            if (count >= 3) {
                break;
            }
            answer++;
        }
        System.out.println(answer);
    }
}
