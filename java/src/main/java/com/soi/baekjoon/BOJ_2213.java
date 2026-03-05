package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class BOJ_2213 {
    private static int[] arr;
    private static int[][] dp;
    private static int n;
    private static List<Integer>[] conn;
    private static List<Integer> answer;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        conn = new List[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            conn[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) { // tree
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            conn[u].add(v);
            conn[v].add(u);
        }
        dp = new int[n + 1][2];
        for (int[] dd : dp) {
            Arrays.fill(dd, -1);
        }
        dp(1, 0, true);
        dp(1, 0, false);
        int max = Math.max(dp[1][0], dp[1][1]);
        visited = new boolean[n + 1];
        answer = new ArrayList<>();
        visited[1] = true;
        track(1, 0, dp[1][1] > dp[1][0]);
        System.out.println(max);
        System.out.println(answer.stream().sorted().map(String::valueOf).collect(Collectors.joining(" ")));
    }

    private static int dp(int curr, int parent, boolean selected) {
        if (dp[curr][selected ? 1 : 0] != -1) {
            return dp[curr][selected ? 1 : 0];
        }
        int max = 0;
        for (int next : conn[curr]) {
            if (next == parent) {
                continue;
            }
            if (selected) {
                max += dp(next, curr, false);
            } else {
                max += Math.max(dp(next, curr, true), dp(next, curr, false));
            }
        }
        return dp[curr][selected ? 1 : 0] = (selected ? arr[curr] : 0) + max;
    }

    private static void track(int curr, int parent, boolean selected) {
        if (selected) {
            answer.add(curr);
        }
        for (int next : conn[curr]) {
            if (next == parent) continue;
            if (selected) {
                track(next, curr, false);
            } else {
                track(next, curr, dp[next][1] >= dp[next][0]);
            }
        }
    }
}
