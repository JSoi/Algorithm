package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class N1368 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Edge>[] graph = new ArrayList[N + 1];  // 0번 노드 포함
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i <= N; i++) {
            int wellCost = Integer.parseInt(br.readLine());
            graph[0].add(new Edge(i, wellCost));
            graph[i].add(new Edge(0, wellCost));
        }
        for (int i = 1; i <= N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 1; j <= N; j++) {
                int cost = Integer.parseInt(line[j - 1]);
                if (i != j) {
                    graph[i].add(new Edge(j, cost));
                }
            }
        }

        boolean[] visited = new boolean[N + 1];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(0, 0));

        long answer = 0;

        while (!pq.isEmpty()) {
            Edge curr = pq.poll();
            if (visited[curr.to]) continue;

            visited[curr.to] = true;
            answer += curr.cost;

            for (Edge next : graph[curr.to]) {
                if (!visited[next.to]) {
                    pq.add(next);
                }
            }
        }
        System.out.println(answer);
    }

    private static class Edge implements Comparable<Edge> {
        int to;
        int cost;

        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

}
