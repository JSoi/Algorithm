package com.soi.programmers;

public class POG_161988 {
    public static void main(String[] args) {
        long solution = new POG_161988().solution(new int[]{2, 3, -6, 1, 3, -1, 2, 4});
        System.out.println("solution = " + solution);
    }

    public long solution(int[] sequence) {
        if (sequence.length == 1) {
            return Math.abs(sequence[0]);
        }
        long[][] dp = new long[sequence.length][2];
        // 0) * -1
        // 1) * +1
        dp[sequence.length - 1][0] -= sequence[sequence.length - 1];
        dp[sequence.length - 1][1] += sequence[sequence.length - 1];
        long max = Long.MIN_VALUE;
        for (int i = dp.length - 2; i >= 0; i--) {
            dp[i][0] = Math.max(0, dp[i + 1][1]) - sequence[i];
            dp[i][1] = Math.max(0, dp[i + 1][0]) + sequence[i];
            max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
        }
        return max;
    }
}
