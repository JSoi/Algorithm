package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class N11437 {
    static List<Integer>[] conn;
    static int[] parent, depth;
    static boolean[] visited;
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());

        conn = new ArrayList[n + 1];
        parent = new int[n + 1];
        depth = new int[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            conn[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            conn[a].add(b);
            conn[b].add(a);
        }

        buildTree(1);

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(lca(a, b)).append('\n');
        }

        System.out.print(sb);
    }

    static void buildTree(int root) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(root);
        visited[root] = true;
        parent[root] = 1;
        depth[root] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int nxt : conn[cur]) {
                if (visited[nxt]) continue;
                visited[nxt] = true;
                parent[nxt] = cur;
                depth[nxt] = depth[cur] + 1;
                q.offer(nxt);
            }
        }
    }

    static int lca(int a, int b) {
        while (depth[a] > depth[b]) {
            a = parent[a];
        }
        while (depth[b] > depth[a]) {
            b = parent[b];
        }
        while (a != b) {
            a = parent[a];
            b = parent[b];
        }
        return a;
    }
}