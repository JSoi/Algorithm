package com.soi.baekjoon;

import java.util.Scanner;

public class BOJ_1402 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int caseCount = Integer.parseInt(scan.nextLine());
        StringBuffer buffer = new StringBuffer();
        while (caseCount-- > 0) {
            scan.nextLine();
            buffer.append("yes\n");
        }
        System.out.println(buffer);
    }
}
