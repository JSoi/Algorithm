package com.soi.leetcode;

public class LC_557 {
    public String reverseWords(String str) {
        String answer = "";
        String[] split = str.split(" ");
        for (int i = 0; i < split.length; i++) {
            answer += giveStr(split[i]) + " ";
        }
        return answer.strip();
    }

    public String giveStr(String str) {
        char[] s = str.toCharArray();
        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i - 1] = temp;
        }
        return new String(s);
    }
}
