package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N1939 {
    static List<Edge>[] graph;
    static int N, from, to;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        int maxWeight = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Edge(v, w));
            graph[v].add(new Edge(u, w));  // 양방향
            maxWeight = Math.max(maxWeight, w);
        }

        st = new StringTokenizer(br.readLine());
        from = Integer.parseInt(st.nextToken());
        to = Integer.parseInt(st.nextToken());

        int low = 1, high = maxWeight, answer = 0;
        // 이분탐색으로 무게 결정
        while (low <= high) {
            int mid = (low + high) / 2;
            if (canGo(mid)) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(answer);
    }

    static boolean canGo(int weight) {
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(from);
        visited[from] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur == to) return true;

            for (Edge e : graph[cur]) {
                if (!visited[e.to] && e.weight >= weight) {
                    visited[e.to] = true;
                    queue.offer(e.to);
                }
            }
        }

        return false;
    }

    private static class Edge {
        int to, weight;
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}
