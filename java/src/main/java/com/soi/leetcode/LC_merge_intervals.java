package com.soi.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class LC_merge_intervals {
    public static void main(String[] args) {
        LC_merge_intervals lc = new LC_merge_intervals();
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] result = lc.merge(intervals);
        System.out.println(Arrays.deepToString(result));
    }

    public int[][] merge(int[][] intervals) {
        // sort
        Arrays.sort(intervals, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]));
        ArrayList<int[]> answer = new ArrayList<>();
        for (int[] interval : intervals) {
            if (answer.isEmpty()) {
                answer.add(interval);
                continue;
            }
            int[] slice = answer.getLast();
            // overlap
            if (slice[1] >= interval[0]) {
                slice[1] = Math.max(slice[1], interval[1]);
            } else {
                answer.add(interval);
            }
        }
        return answer.toArray(int[][]::new);
    }
}
