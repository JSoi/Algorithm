package com.soi.leetcode;

import java.util.Arrays;

public class LC_path_existence_queries_in_a_graph_i {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        boolean[] answer = new boolean[queries.length];
        int[] graph = new int[n];
        Arrays.fill(graph, -1);
        for (int i = 0; i < n; i++) {
            if (graph[i] != -1) continue;
            dfs(i, i, maxDiff, nums, graph);
        }
        for (int i = 0; i < queries.length; i++) {
            answer[i] = graph[queries[i][0]] == graph[queries[i][1]];
        }
        return answer;
    }

    private void dfs(int curr, int root, int maxDist, int[] dist, int[] graph) {
        graph[curr] = root;
        for (int j = curr + 1; j < dist.length; j++) {
            if (dist[j] - dist[curr] > maxDist || graph[j] != -1) {
                return;
            }
            dfs(j, root, maxDist, dist, graph);
        }
    }
}
