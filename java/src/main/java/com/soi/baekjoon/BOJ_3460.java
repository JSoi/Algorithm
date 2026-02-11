package com.soi.baekjoon;

import java.util.Scanner;

public class BOJ_3460 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int testCase = scan.nextInt();
        StringBuffer buf = new StringBuffer();
        for (int t = 0; t < testCase; t++) {
            int input = scan.nextInt();
            String result = cal(input);
            for (int i = 0; i < result.length(); i++) {
                if (result.charAt(result.length() - i - 1) == '1') {
                    buf.append(i + " ");
                }
            }
            buf.append("\n");
        }
        System.out.println(buf);
    }

    static String cal(int input) {
        int nin = input;
        String ans = "";
        while (nin > 0) {
            ans = (nin % 2) + ans;
            nin /= 2;
        }
        return ans;
    }
}
