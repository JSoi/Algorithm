package com.soi.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC_remove_invalid_parenteses {
    public static void main(String[] args) {
        LC_remove_invalid_parenteses solution = new LC_remove_invalid_parenteses();
//        String s = "x(";
//        String s = "()())()";
        String s = "((((((((((((((((((aaaaa))";
        List<String> result = solution.removeInvalidParentheses(s);
        System.out.println(result); // Output: ["()()()", "(())()"]
    }

    private Set<String> answer;
    private String s;

    public List<String> removeInvalidParentheses(String s) {
        answer = new HashSet<>();
        this.s = s;

        int l = 0, r = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                l++;
            } else if (s.charAt(i) == ')') {
                if (l > 0) {
                    l--;
                } else {
                    r++;
                }
            }
        }
        dfs(0, "", l, r, 0);
        return new ArrayList<>(answer);
    }

    private void dfs(int idx, String curr, int l, int r, int open) {
        if (open < 0 || l < 0 || r < 0)
            return;
        if (idx == s.length()) {
            if (open == 0 && l == 0 && r == 0)
                answer.add(curr);
            return;
        }
        char c = s.charAt(idx);
        if (c == '(') {
            if (l > 0)
                dfs(idx + 1, curr, l - 1, r, open);
            dfs(idx + 1, curr + c, l, r, open + 1);
        } else if (c == ')') { // )
            if (r > 0) {
                dfs(idx + 1, curr, l, r - 1, open);
            }
            if (open > 0)
                dfs(idx + 1, curr + c, l, r, open - 1);
        } else {
            dfs(idx + 1, curr + c, l, r, open);
        }
    }
}
