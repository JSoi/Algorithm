package com.soi.baekjoon;

import java.util.Scanner;

public class BOJ_27866 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int idx = sc.nextInt();
        sc.close();
        System.out.println(input.charAt(idx - 1));
    }
}
