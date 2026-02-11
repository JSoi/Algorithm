package com.soi.programmers;

public class POG_12907 {
    public static void main(String[] args) {
        int solution = new POG_12907().solution(5, new int[]{1, 2, 5});
        System.out.println(solution);
    }


    public int solution(int n, int[] money) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int coin : money) {
            for (int i = coin; i <= n; i++) {
                dp[i] = (dp[i] + dp[i - coin]) % 1000000007;
            }
        }
        return dp[n];
    }
}
