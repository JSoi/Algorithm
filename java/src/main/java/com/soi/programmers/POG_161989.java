package com.soi.programmers;

import java.util.Arrays;

/**
 * @See <a href="https://school.programmers.co.kr/learn/courses/30/lessons/161989">덧칠하기</a>
 */
public class POG_161989 {
    public static int solution(int n, int m, int[] section) {
        int answer = 0;
        boolean[] painted = new boolean[n];
        Arrays.fill(painted, true);
        for (int s : section) {
            painted[s - 1] = false;
        }
        for (int half = 0; half < (section.length + 1) / 2; half++) {
            int left = half;
            int right = section.length - left - 1;
            if (!painted[section[left] - 1]) {
                for (int i = section[left] - 1; i < section[left] + m - 1 && i < n; i++) {
                    painted[i] = true;
                }
                answer++;
            }
            if (left == right) {
                continue;
            }
            if (!painted[section[right] - 1]) {
                for (int i = section[right] - 1; i > section[right] - m - 1 && i >= 0; i--) {
                    painted[i] = true;
                }
                answer++;
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(8, 4, new int[]{2, 3, 6}));
        System.out.println(solution(5, 4, new int[]{1, 3}));
        System.out.println(solution(10, 1, new int[]{1, 2, 3, 4}));
        System.out.println(solution(10, 1, new int[]{1, 2, 3, 4, 5}));
        System.out.println(solution(100, 50, new int[]{1, 50}));
        System.out.println(solution(100, 30, new int[]{1, 30, 71, 100}));
    }
}
