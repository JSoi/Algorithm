package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1949 {
    private static int n;
    private static int[] population;
    private static List<Integer>[] conn;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
        conn = new List[n + 1];
        population = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            population[i] = Integer.parseInt(tok.nextToken());
            conn[i] = new ArrayList<>();
        }
        for (int i = 1; i <= n - 1; i++) {
            tok = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(tok.nextToken());
            int v = Integer.parseInt(tok.nextToken());
            conn[u].add(v);
            conn[v].add(u);
        }
        dp = new int[n + 1][2];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        int first = dp(-1, 1, false);
        int second = dp(-1, 1, true);
        System.out.println(Math.max(first, second));
//        for (int[] ints : dp) {
//            System.out.println(Arrays.toString(ints));
//        }
    }

    private static int dp(int prev, int target, boolean visit) { // preㅇ
        if (dp[target][visit ? 1 : 0] != -1) {
            return dp[target][visit ? 1 : 0];
        }
        int maxPopulation = visit ? population[target] : 0;
        for (int next : conn[target]) {
            if (next == prev) {
                continue;
            }
            if (visit) {
                maxPopulation += dp(target, next, false);
            } else {
                maxPopulation += Math.max(dp(target, next, true), dp(target, next, false));
            }
        }
        return dp[target][visit ? 1 : 0] = maxPopulation;
    }
}
