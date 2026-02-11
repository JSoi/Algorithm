package com.soi.baekjoon;

import java.util.Scanner;

public class BOJ_4153 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int a, b, c;
        StringBuffer buf = new StringBuffer();
        int bigPortion, smallPortion = 0;
        while (true) {
            a = scan.nextInt();
            b = scan.nextInt();
            c = scan.nextInt();
            if (a == 0 && b == 0 && c == 0) {
                System.out.println(buf);
                return;
            }
            if (a >= Math.max(b, c)) {
                bigPortion = a * a;
                smallPortion = b * b + c * c;
            } else if (b >= Math.max(a, c)) {
                bigPortion = b * b;
                smallPortion = a * a + c * c;
            } else {
                bigPortion = c * c;
                smallPortion = a * a + b * b;
            }
            if (bigPortion == smallPortion) {
                buf.append("right\n");
            } else {
                buf.append("wrong\n");

            }
        }
    }

}
