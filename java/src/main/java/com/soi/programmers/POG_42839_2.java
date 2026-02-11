package com.soi.programmers;

import java.util.HashSet;

public class POG_42839_2 {
    static HashSet<Integer> set;
    static String[] arr;
    static boolean[] visit;

    static int solution(String numbers) {
        set = new HashSet<Integer>();
        makeNumbers(numbers);

        return set.size();
    }

    static boolean isPrime(int num) {
        if (num == 0 || num == 1) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void makeNumbers(String input) {
        arr = new String[input.length()];
        for (int i = 0; i < input.length(); i++) {
            arr[i] = input.charAt(i) + "";
        }
        for (int k = 1; k <= input.length(); k++) {
            visit = new boolean[input.length()];
            mnum("", k);
        }
    }

    static void mnum(String value, int count) {
        if (count == 0) {
            int realVal = Integer.parseInt(value);
            if (isPrime(realVal)) {
                System.out.println(realVal);
                set.add(realVal);
            }
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                mnum(value + arr[i], count - 1);
                visit[i] = false;
            }
        }

    }

    public static void main(String[] args) {

        System.out.println(solution("011"));
    }

}
