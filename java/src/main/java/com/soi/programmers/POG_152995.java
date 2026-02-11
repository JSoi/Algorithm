package com.soi.programmers;

import java.util.Arrays;

public class POG_152995 {
    public static void main(String[] args) {
        System.out.println(new POG_152995().solution(new int[][]{{4, 6}, {6, 4}, {1, 8}, {5, 7}})); // -1
        System.out.println(new POG_152995().solution(new int[][]{{4, 3}, {5, 2}, {5, 1}, {4, 5}, {4, 4}})); // 3
        System.out.println(new POG_152995().solution(new int[][]{{1, 1}, {1, 1}, {1, 1}, {1, 1}, {1, 1}})); // 1
        System.out.println(new POG_152995().solution(new int[][]{{3, 1}, {1, 4}, {2, 3}, {2, 3}, {1, 5}, {1, 0}, {1, 0}})); // 5
        System.out.println(new POG_152995().solution(new int[][]{{5, 5}, {4, 6}, {3, 7}, {2, 9}})); // 2
    }

    public int solution(int[][] scores) {
        // attitude, colleague
        int inhoAttitude = scores[0][0];
        int inhoColleague = scores[0][1];
        Arrays.sort(scores, (s1, s2) -> s2[0] == s1[0] ? s1[1] - s2[1] : s2[0] - s1[0]);
        int rank = 1;
        int colleague = 0;
        for (int[] score : scores) {
            if (inhoAttitude < score[0] && inhoColleague < score[1]) { // 인센 X
                return -1;
            }
            if (colleague <= score[1]) {
                colleague = score[1];
                if (inhoAttitude + inhoColleague < score[0] + score[1]) {
                    rank++;
                }
            }
        }
        return rank;
    }
}
