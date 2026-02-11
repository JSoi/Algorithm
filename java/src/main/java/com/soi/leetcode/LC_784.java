package com.soi.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC_784 {
    public List<String> letterCasePermutation(String s) {
        List<String> answer = new ArrayList<String>();
        if (s.length() == 0) {
            return answer;
        }
        if (s.length() == 1) {
            if (Character.isAlphabetic(s.charAt(0))) {
                answer.add(s.toUpperCase());
                answer.add(s.toLowerCase());
            } else {
                answer.add(s);
            }
            return answer;
        }
        List<String> temp = letterCasePermutation(s.substring(1));
        if (Character.isAlphabetic(s.charAt(0))) {
            for (String str : temp) {
                answer.add((s.charAt(0) + "").toUpperCase() + str);
                answer.add((s.charAt(0) + "").toLowerCase() + str);
            }
        } else {
            for (String str : temp) {
                answer.add(s.charAt(0) + str);
            }
        }

        return answer;
    }
}
