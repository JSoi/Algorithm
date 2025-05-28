package com.soi.programmers;

import java.util.Arrays;

public class L70129 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new L70129().solution("110010101001")));
        System.out.println(Arrays.toString(new L70129().solution("01110")));
        System.out.println(Arrays.toString(new L70129().solution("1111111")));

    }

    public int[] solution(String s) {
        int[] answer = new int[2];
        while (!s.equals("1")) {
            String bf = s;
            String after = s.replace("0", "");
            answer[1] += bf.length() - after.length();
            s = Integer.toBinaryString(after.length());
            answer[0]++;
        }
        return answer;
    }
}
