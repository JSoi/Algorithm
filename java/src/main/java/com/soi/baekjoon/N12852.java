package com.soi.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class N12852 {

    public static final int MAX = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        int[] dp = new int[n + 1];
        // bottom-up
        Arrays.fill(dp, MAX);
        dp[0] = dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
            dp[i] = Math.min(dp[i], dp[i - 1] + 1);
        }
        System.out.println(dp[n]);
        int minCount = dp[n];
        int idx = n;
        StringBuilder ans = new StringBuilder();
        ans.append(idx).append(" ");
        while (idx > 1) {
            if (idx % 3 == 0 && dp[idx / 3] == minCount - 1) {
                idx = idx / 3;
            } else if (idx % 2 == 0 && dp[idx / 2] == minCount - 1) {
                idx = idx / 2;
            } else {
                idx = idx - 1;
            }
            minCount--;
            ans.append(idx).append(" ");
        }
        System.out.println(ans);
    }
}
