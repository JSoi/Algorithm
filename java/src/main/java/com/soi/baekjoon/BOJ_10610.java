package com.soi.baekjoon;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BOJ_10610 {
    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();
        String[] chars = new String[input.length()];
        int zeroCount = 0;
        int numCount = 0;
        for (int i = 0; i < input.length(); i++) {
            chars[i] = input.charAt(i) + "";
            int num = Integer.parseInt(chars[i]);
            numCount += num;
            if (num == 0) {
                zeroCount++;
            }
        }
        if (zeroCount == 0 || numCount % 3 != 0) {
            System.out.println(-1);
            return;
        }
        Arrays.sort(chars, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (String cc : chars) {
            sb.append(cc);
        }
        System.out.println(sb);
    }
}
