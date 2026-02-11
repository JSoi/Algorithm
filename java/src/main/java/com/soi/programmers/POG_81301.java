package com.soi.programmers;

public class POG_81301 {

    public static void main(String[] args) {

        System.out.println(solution("one4seveneight"));
    }

    public static int solution(String s) {
        String[] arr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for (int a = 0; a < arr.length; a++) {
            s = s.replaceAll(arr[a], a + "");
        }
        System.out.println(s);
        return Integer.parseInt(s);
    }
}
