package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1120 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputStr = br.readLine().split(" ");
        System.out.println(getMin(inputStr[0], inputStr[1]));
    }

    private static int getMin(String a, String b) {
        int answer = Integer.MAX_VALUE;
        for (int shift = 0; shift <= b.length() - a.length(); shift++) {
            int tempAnswer = 0;
            for (int aIndex = 0; aIndex < a.length(); aIndex++) {
                if (a.charAt(aIndex) != b.charAt(aIndex + shift)) {
                    tempAnswer++;
                }
            }
            answer = Math.min(answer, tempAnswer);
        }
        return answer;
    }
}
