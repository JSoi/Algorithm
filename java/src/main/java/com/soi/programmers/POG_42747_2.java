package com.soi.programmers;

import java.util.Arrays;

public class POG_42747_2 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 0, 6, 1, 5}));
    }

    static int solution(int[] citations) {
        int N = citations.length;
        int answer = 0;
        Arrays.sort(citations);
        // 0 1 3 5 6


        for (int i = N - 1; i >= 0; i--) {
            if (answer < citations[i]) {
                answer++;
            } else {
                break;
            }
        }
        return answer;
    }
}
