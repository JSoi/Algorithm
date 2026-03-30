package com.soi.baekjoon;

import java.util.HashSet;
import java.util.Scanner;

public class BOJ_18129 {
    public static void main(String[] args) {
        HashSet<Character> set = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String line = input.split(" ")[0].toUpperCase();
        int count = Integer.parseInt(input.split(" ")[1]);
        int idx = 0;
        StringBuilder sb = new StringBuilder();
        while (idx < line.length()) {
            char curr = line.charAt(idx);
            int currCount = 0;
            while (idx < line.length() && line.charAt(idx) == curr) {
                idx++;
                currCount++;
            }
            if (set.contains(curr)) continue;
            if (currCount < count) {
                sb.append(0);
            } else {
                sb.append(1);
            }
            set.add(curr);
        }
        System.out.println(sb);

    }
}
