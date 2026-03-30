package com.soi.baekjoon;

import java.util.Scanner;

public class BOJ_11655 {
    public static void main(String[] args) {
        String s = new Scanner(System.in).nextLine();
        StringBuffer sb = new StringBuffer();
        for (char c : s.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                sb.append(toROT13(c));
            } else {
                sb.append(c);
            }
        }
        System.out.println(sb);
    }

    private static char toROT13(char c) {
        if (Character.isUpperCase(c)) {
            return (char) ((c - 'A' + 13) % 26 + 'A');
        } else {
            return (char) ((c - 'a' + 13) % 26 + 'a');
        }
    }
}
