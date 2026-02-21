package com.soi.programmers;

import java.util.Arrays;

public class POG_214289 {
    private static final int IMP = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int solution = new POG_214289().solution(28, 18, 26, 10, 8, new int[]{0, 0, 1, 1, 1, 1, 1});
        System.out.println("solution = " + solution);
    }

    public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
        temperature += 11;
        t1 += 11;
        t2 += 11;
        // dp[temp][time]
        int n = onboard.length;
        int[][] dp = new int[52][n];
        for (int[] dd : dp) {
            Arrays.fill(dd, IMP);
        }
        // bottom-up
        // init
        if(onboard[0] == 0){

        }else{

        }
        for (int i = 1; i < n; i++) {
            int from = 1;
            int to = 51;
            if (onboard[i] == 1) {
                from = t1;
                to = t2;
            }
            for (int t = from; t <= to; t++) {
                if (dp[t][i] == IMP) {
                    continue;
                }
                // off
                if (t == temperature) {
                    dp[t][i + 1] = dp[t][i];
                } else if (t < temperature) {
                    dp[t + 1][i + 1] = dp[t][i];
                } else {
                    dp[t - 1][i + 1] = dp[t][i];
                }
                dp[t + 1][i + 1] = Math.min(dp[t + 1][i + 1], dp[t][i] + b);
                dp[t - 1][i + 1] = Math.min(dp[t - 1][i + 1], dp[t][i] + b);
                dp[t][i + 1] = Math.min(dp[t][i + 1], dp[t][i] + a);

            }
        }
        int answer = Integer.MAX_VALUE;
        for (int t = onboard[n - 1] == 1 ? t1 : 0; t <= (onboard[n - 1] == 1 ? t2 : 50); t++) {
            answer = Math.min(answer, dp[t][n - 1]);
        }
        for (int[] dd : dp) {
            System.out.println(Arrays.toString(dd));
        }
        return answer;
    }
}
