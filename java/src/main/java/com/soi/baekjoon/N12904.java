package com.soi.baekjoon;

import java.util.Scanner;

public class N12904 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
        StringBuilder sb = new StringBuilder(t);
        sc.close();
        while (sb.length() > s.length()) {
            if (sb.charAt(sb.length() - 1) == 'A') {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.deleteCharAt(sb.length() - 1);
                sb.reverse();
            }
        }
        System.out.println(sb.toString().equals(s) ? 1 : 0);
    }
}
