package com.soi.programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class POG_1837 {
    public static void main(String[] args) {
        int answer = solution(7, 10, new int[][]{{1, 2}, {1, 3}, {2, 3}, {2, 4}, {3, 4}, {3, 5}, {4, 6}, {5, 6}, {5, 7}, {6, 7}}, 6, new int[]{1, 2, 4, 6, 5, 7});
        System.out.println(answer);
    }

    public static final int MAX = Integer.MAX_VALUE;

    public static int solution(int nodes, int m, int[][] edgeList, int gpsCount, int[] gpsLog) {
        Set<Integer>[] conn = new Set[nodes + 1];
        for (int i = 1; i <= nodes; i++) {
            conn[i] = new HashSet<>();
            conn[i].add(i);
        }
        for (int[] edge : edgeList) {
            conn[edge[0]].add(edge[1]);
            conn[edge[1]].add(edge[0]);
        }
        int[][] dp = new int[gpsCount][nodes + 1];
        for (int[] dpd : dp) {
            Arrays.fill(dpd, MAX);
        }
        dp[0][gpsLog[0]] = 0;
        for (int trial = 1; trial < gpsCount; trial++) {
            for (int current = 1; current <= nodes; current++) {
                for (int prev : conn[current]) {
                    if (dp[trial - 1][prev] == MAX) continue;
                    int change = dp[trial - 1][prev] + (gpsLog[trial] == current ? 0 : 1);
                    dp[trial][current] = Math.min(dp[trial][current], change);
                }
            }
        }
        int answer = dp[gpsCount - 1][gpsLog[gpsCount - 1]];
        return answer == MAX ? -1 : answer;
    }
}
