package com.soi.baekjoon;

import java.util.Scanner;

public class BOJ_12919 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String current = sc.nextLine();
        String expect = sc.nextLine();
        System.out.println(canProcess(current, expect) ? 1 : 0);
    }

    public static boolean canProcess(String current, String expect) {
        if (current.equals(expect)) {
            return true;
        }
        if (expect.length() <= current.length()) {
            return false;
        }
        boolean result = false;
        if (expect.charAt(expect.length() - 1) == 'A') {
            result |= canProcess(current, expect.substring(0, expect.length() - 1));
        }
        if (expect.charAt(0) == 'B') {
            StringBuilder sb = new StringBuilder(expect.substring(1));
            sb.reverse();
            result |= canProcess(current, sb.toString());
        }
        return result;
    }
}
