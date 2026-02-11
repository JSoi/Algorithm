package com.soi.programmers;

public class POG_17682 {

    public static void main(String[] args) {

        System.out.println(solution("1S2D*3T"));
        System.out.println(solution("1D2S#10S"));
    }

    public static int solution(String dartResult) {
        String temp = "";
        int[] ints = new int[3];
        int intscount = 0;
        for (int i = 0; i < dartResult.length(); i++) {
            char test = dartResult.charAt(i);
            if (test == 'S' || test == 'D' || test == 'T') {
                int val = Integer.valueOf(temp);
                if (test == 'D')
                    val *= val;
                else if (test == 'T')
                    val *= val * val;
                ints[intscount++] = val;
                temp = "";
            } else if (test >= '0' && test <= '9') {
                temp += test;
            } else {
                int target = intscount - 1;
                if (test == '*') {
                    for (int j = target; j >= target - 1; j--) {
                        if (j < 0) break;
                        ints[j] *= 2;
                    }
                } else {
                    ints[target] *= -1;
                }
            }
        }
        int answer = ints[0] + ints[1] + ints[2];
        return answer;
    }
}
