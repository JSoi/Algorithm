package com.soi.programmers;

import java.util.Arrays;

public class L340212 {
    public static void main(String[] args) {
        int solution = new L340212().solution(new int[]{1, 5, 3}, new int[]{2, 4, 7}, 30);
//        int solution = new L340212().solution(new int[]{1, 99999, 100000, 99995}, new int[]{9999, 9001, 9999, 9001}, 3456789012L); // 39354
        System.out.println(solution);

    }

    public int solution(int[] diffs, int[] times, long limit) {
        int min = 1;
        int max = Arrays.stream(diffs).max().orElse(1);
        while (min < max) {
            int mid = (min + max) / 2;
            if (isLevelReachable(mid, limit, diffs, times)) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }

    private boolean isLevelReachable(int level, long limit, int[] diffs, int[] times) {
        for (int i = 0; i < diffs.length && limit >= 0; i++) {
            long toUse;
            if (diffs[i] <= level) {
                toUse = times[i];
            } else {
                toUse = (long) (diffs[i] - level) * (times[i] + times[i - 1]) + times[i];
            }
            limit -= toUse;
        }
        return limit >= 0;
    }
}
