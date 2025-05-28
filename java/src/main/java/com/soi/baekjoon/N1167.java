package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class N1167 {
    static int farthestNode;
    static int maxDistance;
    static boolean[] visited;
    static List<int[]>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        graph = new List[v + 1];
        for (int i = 0; i <= v; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < v; i++) {
            String[] input = br.readLine().split(" ");
            int node = Integer.parseInt(input[0]);
            for (int j = 1; j < input.length - 1; j += 2) {
                int next = Integer.parseInt(input[j]);
                int weight = Integer.parseInt(input[j + 1]);
                graph[node].add(new int[]{next, weight});
                graph[next].add(new int[]{node, weight});
            }
        }
        farthestNode = 1;
        maxDistance = 0;
        visited = new boolean[v + 1];
        dfs();
        maxDistance = 0;
        visited = new boolean[v + 1];
        dfs();
        System.out.println(maxDistance);
    }

    private static void dfs() {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{farthestNode, maxDistance});
        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            visited[current[0]] = true;
            if (current[1] > maxDistance) {
                maxDistance = current[1];
                farthestNode = current[0];
            }
            for (int[] next : graph[current[0]]) {
                if (visited[next[0]]) continue;
                stack.push(new int[]{next[0], current[1] + next[1]});
            }
        }
    }
}
