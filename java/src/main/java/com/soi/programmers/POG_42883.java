package com.soi.programmers;

import java.util.Stack;

public class POG_42883 {

    public static void main(String[] args) {

        System.out.println(solution("1924", 2));
        System.out.println(solution("1231234", 3));
        System.out.println(solution("999", 2));
        System.out.println(solution("4177252841", 4));
    }


    public static String solution(String number, int k) {
        Stack<Integer> stk = new Stack<Integer>();
        String ans = "";
        for (int i = 0; i < number.length(); i++) {
            int compare = Integer.parseInt(number.charAt(i) + "");
            while (!stk.isEmpty() && compare > stk.peek() && k-- > 0) {

                // System.out.println("compare : " + compare + " stack peek : " + stk.peek());

                stk.pop();
            }
            stk.push(compare);
        }

        while (stk.size() > number.length() - k) {
            stk.pop();
        }

        for (int i = 0; i < stk.size(); i++) {
            ans += stk.get(i) + "";
        }
        return ans;
    }
}
