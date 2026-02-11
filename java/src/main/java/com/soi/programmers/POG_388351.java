package com.soi.programmers;

import java.util.Arrays;

public class POG_388351 {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int n = schedules.length;
        boolean[] treasured = new boolean[n];
        Arrays.fill(treasured, true);
        for (int t = 0; t < 7; t++) {
            int day = (startday + t - 1) % 7 + 1;
            if (day == 6 || day == 7) {
                continue;
            }
            for (int c = 0; c < n; c++) {
                if (!treasured[c]) {
                    continue;
                }
                if (toMinute(timelogs[c][t]) > toMinute(schedules[c]) + 10) {
                    treasured[c] = false;
                }
            }
        }

        int answer = 0;
        for (boolean b : treasured) {
            if (b) {
                answer++;
            }
        }
        return answer;
    }

    private int toMinute(int input) {
        return 60 * (input / 100) + input % 100;
    }
}
