package com.soi.programmers;

public class POG_12937 {
    public String solution(int num) {
        String temp = num + "";
        num = temp.charAt(temp.length() - 1);
        String answer = "";
        if (num % 2 == 1)
            answer = "Odd";
        else
            answer = "Even";
        return answer;
    }
}
