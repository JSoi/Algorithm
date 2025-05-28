package com.soi.programmers;

import java.util.Arrays;

public class L12904 {
    public static void main(String[] args) {
        L12904 test = new L12904();
        int solution = test.solution("abcdcba");
        System.out.println("solution = " + solution);

    }

    public int solution(String s) {
        int len = s.length();
        int[][] palindrome = new int[len][len];
        for (int[] p : palindrome) {
            Arrays.fill(p, -1);
        }
        for (int mid = 0; mid < s.length(); mid++) {
            palindrome[mid][mid] = 1;
        }
        int max = 1;
        for (int from = len - 1; from >= 0; from--) {
            for (int to = from + 1; to < len; to++) {
                if (s.charAt(from) != s.charAt(to)) {
                    continue;
                }
                int result = -1;
                if (to - from == 1) {
                    result = 2;
                } else if (palindrome[from + 1][to - 1] != -1) {
                    result = palindrome[from + 1][to - 1] + 2;
                }
                max = Math.max(max, result);
                palindrome[from][to] = result;
            }
        }
//        Arrays.stream(palindrome).map(Arrays::toString).forEach(System.out::println);
        return max;
    }

}
