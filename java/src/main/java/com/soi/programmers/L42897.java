package com.soi.programmers;

import java.util.*;

public class L42897 {

    public static void main(String[] args) {
        int solution = new L42897().solution(new int[]{1, 2, 3, 1});
        int solution2 = new L42897().solution(new int[]{1, 2, 3});
        System.out.println("solution = " + solution);
    }

    public int solution(int[] money) {
        int len = money.length;
        if (len <= 2) {
            return Arrays.stream(money).max().orElse(0);
        }
        int withFirstHouse = rob(money, 0, len - 2);
        int withoutFirstHouse = rob(money, 1, len - 1);

        return Math.max(withFirstHouse, withoutFirstHouse);
    }

    int rob(int[] money, int start, int end) {
        int p = 0, pp = 0;
        for (int i = start; i <= end; i++) {
            int current = Math.max(p, pp + money[i]);
            pp = p;
            p = current;
        }
        return p;
    }

    public int rob(int[] money) {
        int len = money.length;
        int[][] dp = new int[2][len]; // 0 : without 1st house , 2 : with 1st house
        dp[1][0] = dp[1][1] = money[0];
        dp[0][1] = money[1];
        for (int i = 2; i < len; i++) {
            dp[0][i] = Math.max(dp[0][i - 2] + money[i], dp[0][i - 1]);
            dp[1][i] = Math.max(dp[1][i - 2] + money[i], dp[1][i - 1]);
        }
        return Math.max(dp[1][len - 2], dp[0][len - 1]);
    }
}
