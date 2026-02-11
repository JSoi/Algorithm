package com.soi.programmers;

import java.util.Arrays;

public class POG_12938 {
    public static void main(String[] args) {
        int[] solution = new POG_12938().solution(4, 15);
        System.out.println(Arrays.toString(solution));
    }

    public int[] solution(int n, int s) {
        if (n > s) {
            return new int[]{-1};
        }
        int[] answer = new int[n];
        int answerIdx = 0;
        while (n > 0) {
            answer[answerIdx++] = s / n;
            s -= (s / n);
            n--;
        }
        return answer;
    }
}
