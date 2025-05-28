package com.soi.programmers;

import java.util.Arrays;

public class L87390 {
    public static void main(String[] args) {
        int[] solution = new L87390().solution(3, 2, 5);
        System.out.println(Arrays.toString(solution));
    }

    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left + 1)];
        for (long idx = left; idx <= right; idx++) {
            int r = (int) (idx / n);
            int c = (int) (idx % n);
            answer[(int) (idx - left)] = Math.max(r, c) + 1;
        }
        return answer;
    }
}
