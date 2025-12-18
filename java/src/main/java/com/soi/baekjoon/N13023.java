package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class N13023 {
    private static List<Integer>[] conn;
    private static int n;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(tok.nextToken());
        int m = Integer.parseInt(tok.nextToken());
        conn = new List[n];
        for (int i = 0; i < n; i++) {
            conn[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            tok = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(tok.nextToken());
            int b = Integer.parseInt(tok.nextToken());
            conn[a].add(b);
            conn[b].add(a);
        }
        for (int i = 0; i < n; i++) {
            visited = new boolean[n];
            visited[i] = true;
            if (dfs(i,1)) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }

    private static boolean dfs(int node, int depth) {
        if (depth == 5) return true;
        for (int next : conn[node]) {
            if (visited[next]) continue;
            visited[next] = true;
            if (dfs(next, depth + 1)) return true;
            visited[next] = false;
        }
        return false;
    }
}
