package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class N2056 {
    public static final int MAX = Integer.MAX_VALUE;
    private static int n;
    private static Set<Integer>[] prev;
    private static int[] dp;
    private static int[] workTime;

    public static void main(String[] args) throws IOException {
        input();
        dp = new int[n + 1]; // 끝나는 시간이 기록
        Arrays.fill(dp, MAX);
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            answer = Math.max(answer, dp(i));
        }
        System.out.println(answer);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        workTime = new int[n + 1];
        prev = new Set[n + 1];

        for (int i = 0; i <= n; i++) {
            prev[i] = new HashSet<>();
        }
        for (int i = 1; i <= n; i++) {
            StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
            workTime[i] = Integer.parseInt(tok.nextToken());
            while (tok.hasMoreTokens()) {
                prev[i].add(Integer.parseInt(tok.nextToken()));
            }
        }
    }

    private static int dp(int target) {
        if (dp[target] != MAX) return dp[target];
        int startTime = 0;
        for (int p : prev[target]) {
            startTime = Math.max(startTime, dp(p));
        }
        return dp[target] = startTime + workTime[target];
    }
}
