package com.soi.programmers;

import java.util.Arrays;

public class POG_118668 {
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        System.out.println(solution(10, 10, new int[][]{{0, 15, 2, 1, 2}, {20, 20, 3, 3, 4}}));
    }

    public static int solution(int alp, int cop, int[][] problems) {
        int alpMax = Arrays.stream(problems).mapToInt(a -> a[0]).max().orElse(0);
        int copMax = Arrays.stream(problems).mapToInt(a -> a[1]).max().orElse(0);

        if (alp >= alpMax && cop >= copMax) return 0;

        alpMax = Math.max(alpMax, alp);
        copMax = Math.max(copMax, cop);

        int[][] dp = new int[alpMax + 1][copMax + 1];
        for (int[] d : dp) Arrays.fill(d, INF);
        dp[alp][cop] = 0;

        for (int a = alp; a <= alpMax; a++) {
            for (int c = cop; c <= copMax; c++) {
                if (dp[a][c] == INF) continue;
                if (a + 1 <= alpMax) dp[a + 1][c] = Math.min(dp[a + 1][c], dp[a][c] + 1);
                if (c + 1 <= copMax) dp[a][c + 1] = Math.min(dp[a][c + 1], dp[a][c] + 1);
                for (int[] p : problems) {
                    if (a >= p[0] && c >= p[1]) {
                        int na = Math.min(alpMax, a + p[2]);
                        int nc = Math.min(copMax, c + p[3]);
                        dp[na][nc] = Math.min(dp[na][nc], dp[a][c] + p[4]);
                    }
                }
            }
        }
        return dp[alpMax][copMax];
    }
}
