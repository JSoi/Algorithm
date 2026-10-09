package com.soi.leetcode;

public class LC_minimum_insertions_to_balance_a_parentheses_string {
    public int minInsertions(String s) {
        int left = 0, right = 0, offset = 0;
        int extraCount = 0;
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == '(') {
                left++;
            } else {
                if (i == s.length() - 1) {
                    extraCount++;
                } else {
                    if (s.charAt(i + 1) == ')') {
                        i++;
                    } else {
                        extraCount++;
                    }
                }
                right++;
            }
            if (right > left) {
                left++;
                extraCount++;
            }
            i++;
        }
        extraCount += Math.max(0, left - right) * 2;
        extraCount += Math.max(0, right - left);
        return extraCount;
    }
}
