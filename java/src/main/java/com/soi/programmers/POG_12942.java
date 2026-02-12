package com.soi.programmers;

import java.util.Arrays;

public class POG_12942 {
    private static final int IMP = Integer.MAX_VALUE;
    private static int[][] dp;
    private static int[][] arr;

    public static void main(String[] args) {
        int solution = new POG_12942().solution(new int[][]{{5, 3}, {3, 10}, {10, 6}});
        System.out.println(solution);
    }

    public static int solution(int[][] matrix) {
        int n = matrix.length;
        arr = matrix;
        dp = new int[n][n];
        for (int[] d : dp) {
            Arrays.fill(d, IMP);
        }
        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
        }
        return solve(0, n - 1);
    }

    // top - bottom
    private static int solve(int from, int to) {
        if (dp[from][to] != IMP) {
            return dp[from][to];
        }
        int min = IMP;
        for (int mid = from; mid < to; mid++) {
            int cost = solve(from, mid)
                    + solve(mid + 1, to)
                    + arr[from][0] * arr[mid][1] * arr[to][1];
            min = Math.min(min, cost);
        }
        return dp[from][to] = min;
    }
}
