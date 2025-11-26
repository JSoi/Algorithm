package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N2533 {
    private static boolean[] visit;
    private static int[][] dp;
    private static ArrayList<Integer>[] conn;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        conn = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            conn[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            conn[u].add(v);
            conn[v].add(u);
        }
        dp = new int[N + 1][2];
        visit = new boolean[N + 1];
        dfs(1);
        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }

    private static void dfs(int node) {
        visit[node] = true;
        dp[node][0] = 0;
        dp[node][1] = 1;
        for (int child : conn[node]) {
            if (visit[child]) {
                continue;
            }
            dfs(child);
            dp[node][0] += dp[child][1];
            dp[node][1] += Math.min(dp[child][0], dp[child][1]);
        }
    }
}
