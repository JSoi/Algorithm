package com.soi.programmers;

public class POG_138475 {
    public int[] solution(int e, int[] starts) {
        int[] count = new int[e + 1];
        for (int i = 1; i <= e; i++) {
            for (int j = 1; j <= e / i; j++) {
                count[i * j]++;
            }
        }
        int[] dp = new int[e + 1];
        dp[e] = e;
        for (int i = e - 1; i >= 1; i--) {
            dp[i] = (count[i] >= count[dp[i + 1]]) ? i : dp[i + 1];
        }
        int[] answer = new int[starts.length];
        for (int i = 0; i < answer.length; i++)
            answer[i] = dp[starts[i]];
        return answer;
    }
}
