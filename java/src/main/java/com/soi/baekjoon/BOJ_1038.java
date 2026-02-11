package com.soi.baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BOJ_1038 {
    private static List<Long> list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            find(i, i);
        }
        Collections.sort(list);
        System.out.println(n < list.size() ? list.get(n) : -1);
    }

    private static void find(long num, int lastDigit) {
        list.add(num);
        for (int nextDigit = lastDigit - 1; nextDigit >= 0; nextDigit--) {
            find(num * 10 + nextDigit, nextDigit);
        }
    }
}
