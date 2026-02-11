package com.soi.programmers;

import java.util.Stack;

public class POG_12973 {

    public static void main(String[] args) {

        System.out.println(solution("baabaa"));
    }

    static int solution(String s) {

        Stack<Character> st = new Stack<Character>();
        char[] c = s.toCharArray();
        for (char a : c) {
            if (!st.isEmpty() && st.peek() == a) {
                st.pop();
            } else {
                st.push(a);
            }
        }
        return st.isEmpty() ? 1 : 0;
    }

    static int wrongsolution(String s) {

        String old = "";
        while (!s.equals(old)) {
            old = s;
            s = s.replace("aa", "");
            s = s.replace("bb", "");
        }
        if (s.length() > 0)
            return 0;
        else
            return 1;
    }
}
