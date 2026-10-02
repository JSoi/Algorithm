package com.soi.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC_generate_parentheses {
    private List<String> result;
    private int n;

    public List<String> generateParenthesis(int n) {
        this.n = n;
        result = new ArrayList<>();
        create(0, 0, "");
        return result;
    }

    private void create(int left, int right, String curr) {
        if (left == n && right == n) {
            result.add(curr);
            return;
        }
        if (left < n) {
            create(left + 1, right, curr + "(");
        }
        if (right < n && left > right) {
            create(left, right + 1, curr + ")");
        }
    }
}
