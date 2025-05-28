package com.soi.baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class N1343 {
    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();
        ArrayList<String> strings = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        int i = 0;
        while (i < input.length()) {
            char c = input.charAt(i);
            while (i < input.length() && input.charAt(i) == c) {
                temp.append(c);
                i++;
            }
            String string = temp.toString();
            if (string.startsWith("X") && string.length() % 2 == 1) {
                System.out.println(-1);
                return;
            }
            strings.add(string);
            temp.setLength(0);
        }
//        System.out.println(strings);
        StringBuilder answer = new StringBuilder();
        for (String s : strings) {
            if (s.charAt(0) == '.') {
                answer.append(s);
            } else {
                answer.append("AAAA".repeat(s.length() / 4))
                        .append("BB".repeat(s.length() % 4 > 0 ? 1 : 0));
            }
        }
        System.out.println(answer);
    }
}
