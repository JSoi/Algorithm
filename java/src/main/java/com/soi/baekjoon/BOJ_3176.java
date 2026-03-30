package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_3176 {
    private static class Edge {
        int to, cost;
        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    private static int n, treeHeight;
    private static List<Edge>[] graph;
    private static int[][] parent, minEdge, maxEdge;
    private static int[] depth;
    private static boolean[] visited;

    private static final int MAX = Integer.MAX_VALUE;
    private static final int MIN = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        treeHeight = (int) Math.ceil(Math.log(n) / Math.log(2)); // 높이
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Edge(b, c));
            graph[b].add(new Edge(a, c));
        }

        parent = new int[treeHeight][n + 1];
        minEdge = new int[treeHeight][n + 1];
        maxEdge = new int[treeHeight][n + 1];
        depth = new int[n + 1];
        visited = new boolean[n + 1];

        for (int k = 0; k < treeHeight; k++) {
            Arrays.fill(minEdge[k], MAX);
            Arrays.fill(maxEdge[k], MIN);
        }

        bfs();
        build();

        int q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int[] result = query(a, b);
            sb.append(result[0]).append(' ').append(result[1]).append('\n');
        }
        System.out.print(sb);
    }

    private static void bfs() {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        visited[1] = true; // 1 - tree root
        depth[1] = 0;
        queue.offer(1);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (Edge e : graph[cur]) {
                int next = e.to;
                if (visited[next]) continue;
                visited[next] = true;
                depth[next] = depth[cur] + 1;
                parent[0][next] = cur;
                minEdge[0][next] = maxEdge[0][next] = e.cost;
                queue.offer(next);
            }
        }
    }

    // sparse table : parent[k][v] = parent[k-1][parent[k-1][v]]
    private static void build() {
        for (int k = 1; k < treeHeight; k++) {
            for (int v = 1; v <= n; v++) {
                int mid = parent[k - 1][v];
                parent[k][v] = parent[k - 1][mid];
                minEdge[k][v] = Math.min(minEdge[k - 1][v], minEdge[k - 1][mid]);
                maxEdge[k][v] = Math.max(maxEdge[k - 1][v], maxEdge[k - 1][mid]);
            }
        }
    }

    private static int[] query(int a, int b) {
        int minVal = MAX;
        int maxVal = MIN;

        if (depth[a] < depth[b]) { // 깊이에 따른 순서 보정
            int tmp = a;
            a = b;
            b = tmp;
        }

        for (int k = 0; k < treeHeight; k++) {
            if (((depth[a] - depth[b]) & (1 << k)) != 0) {
                minVal = Math.min(minVal, minEdge[k][a]);
                maxVal = Math.max(maxVal, maxEdge[k][a]);
                a = parent[k][a];
            }
        }

        if (a == b) {
            return new int[]{minVal, maxVal};
        }

        for (int k = treeHeight - 1; k >= 0; k--) {
            if (parent[k][a] != parent[k][b]) {
                minVal = Math.min(minVal, Math.min(minEdge[k][a], minEdge[k][b]));
                maxVal = Math.max(maxVal, Math.max(maxEdge[k][a], maxEdge[k][b]));
                a = parent[k][a];
                b = parent[k][b];
            }
        }

        minVal = Math.min(minVal, Math.min(minEdge[0][a], minEdge[0][b]));
        maxVal = Math.max(maxVal, Math.max(maxEdge[0][a], maxEdge[0][b]));
        return new int[]{minVal, maxVal};
    }

}
