package com.soi.programmers;

public class POG_12901 {
    public static String solution(int a, int b) {
        int[] monthday = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] daystr = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
        int day = 0;
        for (int i = 0; i < a - 1; i++) {
            day += monthday[i];
        }
        day += b;
        String answer = daystr[day % 7];
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(5, 24));
    }

}
