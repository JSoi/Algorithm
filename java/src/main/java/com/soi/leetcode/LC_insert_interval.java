package com.soi.leetcode;

import java.util.*;

public class LC_insert_interval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> intervalsList = new ArrayList<>(Arrays.asList(intervals));
        intervalsList.add(newInterval);
        intervalsList.sort(Comparator.comparingInt(a -> a[0]));
        List<int[]> answer = new ArrayList<>();
        int[] current = intervalsList.getFirst();

        for (int i = 1; i < intervalsList.size(); i++) {
            int[] interval = intervalsList.get(i);
            if (current[1] >= interval[0]) {
                current[1] = Math.max(current[1], interval[1]);
            } else {
                answer.add(current);
                current = interval;
            }
        }
        answer.add(current);
        return answer.toArray(int[][]::new);
    }
}
