package com.soi.programmers;

import java.util.Arrays;

public class POG_131129 {
    private static final int MAX = 100000;
    private static int[] dp, sbCount;
    private static int n;

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(58))); // 2, 2
    }

    public static int[] solution(int target) {
        n = target;
        dp = new int[n + 1];
        sbCount = new int[n + 1];
        Arrays.fill(dp, MAX);
        dp[0] = 0;

        for (int num = 1; num <= 20; num++) {
            for (int p = 1; p <= 3; p++) {
                int point = num * p;
                if (point > n) continue;
                if (dp[point] > 1) {
                    dp[point] = 1;
                    sbCount[point] = p == 1 ? 1 : 0;
                } else if (dp[point] == 1) {
                    sbCount[point] = Math.max(sbCount[point], p == 1 ? 1 : 0);
                }
                compute(point);
            }
        }

        if (n >= 50) {
            dp[50] = 1;
            sbCount[50] = 1;
            compute(50);
        }
        return new int[]{dp[target], sbCount[target]};
    }

    private static void compute(int point) {
        for (int nP = point; nP <= n; nP++) {
            if (dp[nP] < dp[nP - point] + dp[point]) {
                continue;
            }
            if (dp[nP] == dp[nP - point] + dp[point]) {
                sbCount[nP] = Math.max(sbCount[nP], sbCount[nP - point] + sbCount[point]);
            } else {
                sbCount[nP] = sbCount[nP - point] + sbCount[point];
            }
            dp[nP] = dp[nP - point] + dp[point];
        }
    }
}
