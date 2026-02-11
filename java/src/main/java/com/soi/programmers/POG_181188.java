package com.soi.programmers;

import java.util.Arrays;
import java.util.Comparator;

public class POG_181188 {
    public static void main(String[] args) {
        int solution = new POG_181188().solution(new int[][]{{4, 5}, {4, 8}, {10, 14}, {11, 13}, {5, 12}, {3, 7}, {1, 4}});
        System.out.println(solution);

    }

    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, Comparator.comparingInt(t -> t[1]));
        int end = 0;
        for (int[] target : targets) {
            if (target[0] < end) {
                continue;
            }
            answer++;
            end = target[1];
        }
        return answer;
    }
}
