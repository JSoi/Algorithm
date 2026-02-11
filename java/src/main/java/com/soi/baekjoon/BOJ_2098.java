package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2098 {
    public static final int MAX = Integer.MAX_VALUE;
    private static int[][] cost;
    private static int n;

    public static void main(String[] args) throws IOException {
        init();
        int answer = MAX;
        for (int i = 0; i < n; i++) {
            answer = Math.min(answer, TSP(n, i));

        }
        System.out.println(answer);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        cost = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static int TSP(int N, int start) {
        int M = 1 << N;
        int[][] dp = new int[M][N];
        // 행 : status
        for (int[] d : dp) {
            Arrays.fill(d, MAX);
        }
        dp[1 << start][start] = cost[start][start];
        for (int mask = 0; mask < M; mask++) { // asc
            for (int from = 0; from < N; from++) {
                if ((mask & (1 << from)) == 0) continue;
                for (int to = 0; to < N; to++) {
                    if ((mask & (1 << to)) != 0 || dp[mask][from] == MAX || cost[from][to] == 0) continue;
                    dp[mask | (1 << to)][to] = Math.min(dp[mask | (1 << to)][to], dp[mask][from] + cost[from][to]);
                }
            }
        }
        int minCost = MAX;
        for (int i = 0; i < N; i++) {
            if (dp[M - 1][i] == MAX || cost[i][start] == 0) continue;
            minCost = Math.min(minCost, dp[M - 1][i] + cost[i][start]);
        }
        return minCost;
    }
}
