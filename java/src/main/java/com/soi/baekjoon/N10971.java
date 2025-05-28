package com.soi.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class N10971 {

    public static final int MAX = Integer.MAX_VALUE;
    static int[][] cost;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        cost = new int[N][N];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                cost[r][c] = scan.nextInt();
            }
        }
        scan.close();
        int answer = Integer.MAX_VALUE;
        for (int startIdx = 0; startIdx < N; startIdx++) {
            answer = Math.min(answer, TSP(N, startIdx));
        }
        System.out.println(answer);
    }

    private static int TSP(int N, int start) {
        int M = 1 << N;
        int[][] dp = new int[M][N];
        // 행 : 비트마스트(방문 정점)
        for (int[] d : dp) {
            Arrays.fill(d, MAX);
        }
        dp[1 << start][start] = cost[start][start];
        for (int mask = 0; mask < M; mask++) {
            for (int u = 0; u < N; u++) {
                if ((mask & (1 << u)) == 0) continue; // 방문 정점일 시
                for (int v = 0; v < N; v++) {
                    if ((mask & (1 << v)) != 0 || dp[mask][u] == MAX || cost[u][v] == 0) continue;
                    dp[mask | (1 << v)][v] = Math.min(dp[mask | (1 << v)][v], dp[mask][u] + cost[u][v]);
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
