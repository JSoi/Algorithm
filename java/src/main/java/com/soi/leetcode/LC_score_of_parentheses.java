package com.soi.leetcode;

import java.util.Stack;

public class LC_score_of_parentheses {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(sum);
                sum = 0;
            } else {
                sum = stack.pop() + (sum == 0 ? 1 : 2 * sum);
            }
        }
        return sum;
    }
}
