package com.soi.baekjoon;

import java.util.Scanner;

public class BOJ_18238 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        scan.close();
        char[] split = input.toCharArray();
        int ans = time('a', split[0]);
        for (int i = 0; i < split.length - 1; i++) {
            ans += time(split[i], split[i + 1]);
        }
        System.out.println(ans);
    }

    public static int time(char start, char end) {
        int time = 0;
        time = Math.abs(start - end);
        if (time > 13)
            time = 26 - time;
        System.out.println(time);
        return time;
    }
}
