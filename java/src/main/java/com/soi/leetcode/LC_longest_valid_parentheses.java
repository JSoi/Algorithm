package com.soi.leetcode;

public class LC_longest_valid_parentheses {
    public int longestValidParentheses(String s) {
        int answer = 0;
        int count = 0;
        int[] valid = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(')
                count++;
            else {
                if (count <= 0)
                    continue;
                valid[i] = 2 + valid[i - 1];
                if (i - valid[i] > 0) {
                    valid[i] += valid[i - valid[i]];
                }
                count--;
            }
            answer = Math.max(valid[i], answer);
        }
        return answer;
    }
}
