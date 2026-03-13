package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_16437 {
    private static int n;
    private static boolean[] visited;
    private static int[] animalCount;
    private static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        // graph
        animalCount = new int[n + 1];
        for (int child = 2; child <= n; child++) {
            StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
            String type = tok.nextToken();
            int count = Integer.parseInt(tok.nextToken());
            animalCount[child] = (type.equals("S") ? 1 : -1) * count;
            int parent = Integer.parseInt(tok.nextToken());
            graph[child].add(parent);
            graph[parent].add(child);
        }
        visited = new boolean[n + 1];
        visited[1] = true;
        System.out.println(dfs(1));
    }

    // dfs - return survived sheep
    private static long dfs(int node) {
        int currCount = animalCount[node];
        long subSheepCount = 0;
        for (int next : graph[node]) {
            if (visited[next]) continue;
            visited[next] = true;
            subSheepCount += dfs(next);
        }
        return Math.max(0, subSheepCount + currCount);
    }
}
