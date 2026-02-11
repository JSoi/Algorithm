package com.soi.baekjoon;

import java.util.Scanner;

public class BOJ_9095 {

    public static void main(String[] args) {

        @SuppressWarnings("resource")
        Scanner scan = new Scanner(System.in);
        StringBuffer buf = new StringBuffer();
        int c = scan.nextInt();
        for (; c > 0; c--) {
            int t = scan.nextInt();
            buf.append(per(t) + "\n");
        }
        scan.close();
        System.out.println(buf);
    }

    public static int per(int input) {
        int a = 0;
        if (input < 0) {
            return 0;
        } else if (input == 0) {
            return 1;
        } else {
            a += per(input - 3);
            a += per(input - 2);
            a += per(input - 1);
        }
        return a;
    }
}
