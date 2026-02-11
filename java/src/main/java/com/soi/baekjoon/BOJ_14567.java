package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_14567 {
    private static int N;
    private static int[] depth;
    private static List<Integer>[] conn;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(tok.nextToken());
        int M = Integer.parseInt(tok.nextToken());
        conn = new List[N + 1];
        for (int i = 0; i <= N; i++) {
            conn[i] = new ArrayList<>();
        }
        boolean[] isRoot = new boolean[N + 1];
        Arrays.fill(isRoot, true);
        for (int i = 0; i < M; i++) {
            tok = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(tok.nextToken());
            int b = Integer.parseInt(tok.nextToken());
            conn[a].add(b);
            isRoot[b] = false;
        }
        depth = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            if (isRoot[i]) {
                dfs(i, 1);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(depth[i]).append(" ");
        }
        System.out.println(sb);

    }

    private static void dfs(int target, int d) {
        depth[target] = Math.max(depth[target], d);
        for (int next : conn[target]) {
            if (depth[next] > d) continue;
            dfs(next, d + 1);
        }
    }
}
