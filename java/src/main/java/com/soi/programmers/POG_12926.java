package com.soi.programmers;

public class POG_12926 {
    public String solution(String s, int n) {
        char[] split = s.toCharArray();
        String answer = "";
        for (int i = 0; i < s.length(); i++) {
            answer += smallsol(split[i], n);
        }
        return answer;
    }

    public char smallsol(char s, int n) {
        if (s == ' ')
            return ' ';
        else if (s >= 'A' && s <= 'Z') {
            if (s + n > 'Z')
                return (char) (s + n - 26);
            else
                return (char) (s + n);
        } else {
            if (s + n > 'z')
                return (char) (s + n - 26);
            else
                return (char) (s + n);
        }
    }
}
