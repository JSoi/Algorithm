package com.soi.programmers;

public class POG_12909 {

    public static void main(String[] args) {

        System.out.println(solution("()()"));
    }

    static boolean solution(String s) {
        int val = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                val++;
            else
                val--;
            if (val < 0)
                return false;
        }
        return val == 0;
    }
}
