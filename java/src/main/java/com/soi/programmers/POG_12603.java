package com.soi.programmers;

public class POG_12603 {
    public static String solution(String s) {
        int length = s.length();
        int mid = length / 2;
        if (length == 1)
            return s;
        if (length % 2 == 0)
            return "" + s.charAt(mid - 1) + s.charAt(mid);
        return s.charAt(mid) + "";
    }

    public static void main(String[] args) {

        System.out.println(solution("hellow"));
    }

}
