package com.soi.programmers;

import java.util.Arrays;

public class POG_12941 {

    public static void main(String[] args) {

        System.out.println(solution(new int[]{1, 4, 2}, new int[]{5, 4, 4}));
    }

    static int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        for (int i = 0; i < A.length; i++) {
            int j = B.length - i - 1;
            answer += A[i] * B[j];
        }
        return answer;
    }
}
