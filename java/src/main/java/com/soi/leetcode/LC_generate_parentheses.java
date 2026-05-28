package com.soi.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC_generate_parentheses {
    static class Solution {
        List<String> answer = new ArrayList<>();

        public List<String> generateParenthesis(int n) {
            pt(0, 0, "", n);
            return answer;
        }

        void pt(int left, int right, String curr, int n) {
            if (left + right == 2 * n) {
                if (left == right)
                    answer.add(curr);
                return;
            }
            if (left < n && left >= right) {
                pt(left + 1, right, curr + "(", n);
            }
            if (right < n && right < left) {
                pt(left, right + 1, curr + ")", n);
            }
        }
    }
}
