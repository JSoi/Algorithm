package com.soi.baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ_1085 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        int y = scan.nextInt();
        int w = scan.nextInt();
        int h = scan.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(x);
        list.add(y);
        list.add(w - x);
        list.add(h - y);
        Collections.sort(list);
        System.out.println(list.get(0));
    }

}
