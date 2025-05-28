package com.soi.programmers;

import java.util.logging.Logger;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/135808">과일 장수</a>
 */
public class L135808 {
    public int solution(int k, int m, int[] score) {
        // k : max score
        // m : box size
        // score : score of each fruit
        int answer = 0;
        int[] scoreCount = new int[k + 1];
        for (int s : score) {
            scoreCount[s]++;
        }
        int boxCount = m;
        for (int sc = k; sc >= 1; sc--) {
            while (scoreCount[sc] > 0) {
                scoreCount[sc]--;
                boxCount--;
                if (boxCount == 0) {
                    answer += sc * m;
                    boxCount = m;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int k = 3;
        int m = 4;
        int[] score = {1, 2, 3, 1,2,3,1};
        int solution = new L135808().solution(k, m, score);
        Logger.getLogger(L135808.class.getName()).info(String.valueOf(solution));

    }
}
