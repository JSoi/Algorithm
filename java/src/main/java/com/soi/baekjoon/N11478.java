package com.soi.baekjoon;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class N11478 {
    public static void main(String[] args) {
        String s = new Scanner(System.in).nextLine();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(s.charAt(i));
            set.add(sb.toString());
            for (int j = i + 1; j < s.length(); j++) {
                sb.append(s.charAt(j));
                set.add(sb.toString());
            }
        }
        System.out.println(set.size());
    }
}
