package com.soi.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1334 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String target = scan.nextLine();
        System.out.println(nextPalindrome(target));
    }

    public static String nextPalindrome(String num) {
        int len = num.length();
        char[] arr = num.toCharArray();

        for (int i = 0; i < len / 2; i++) {
            arr[len - 1 - i] = arr[i];
        }

        String candidate = new String(arr);
        if (candidate.compareTo(num) > 0) {
            return candidate;
        }

        int mid = (len - 1) / 2;
        while (mid >= 0) {
            if (arr[mid] != '9') {
                arr[mid]++;
                arr[len - 1 - mid] = arr[mid];
                break;
            } else {
                arr[mid] = '0';
                arr[len - 1 - mid] = '0';
                mid--;
            }
        }

        if (mid < 0) {
            char[] res = new char[len + 1];
            res[0] = '1';
            res[len] = '1';
            Arrays.fill(res, 1, len, '0');
            return new String(res);
        }

        for (int i = 0; i < len / 2; i++) {
            arr[len - 1 - i] = arr[i];
        }
        return new String(arr);
    }
}
