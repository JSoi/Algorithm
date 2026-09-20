package com.soi.leetcode;

public class LC_reverse_degree_of_a_string {
    public int reverseDegree(String s) {
        int answer = 0;
        for (int i = 1; i <= s.length(); i++) {
            answer += (26 - (s.charAt(i - 1) - 'a')) * i;
        }
        return answer;
    }
}
