package com.soi.baekjoon;

import java.io.*;
import java.util.*;

public class N5719 {
    private static int N, M, start, end;
    private static int[] cost;
    private static List<Node>[] conn;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(tok.nextToken());
            M = Integer.parseInt(tok.nextToken());
            if (N == 0 && M == 0) break;
            tok = new StringTokenizer(br.readLine(), " ");
            start = Integer.parseInt(tok.nextToken());
            end = Integer.parseInt(tok.nextToken());
            conn = new List[N];
            for (int i = 0; i < N; i++) {
                conn[i] = new ArrayList<>();
            }
            for (int i = 0; i < M; i++) {
                tok = new StringTokenizer(br.readLine(), " ");
                int u = Integer.parseInt(tok.nextToken());
                int v = Integer.parseInt(tok.nextToken());
                int p = Integer.parseInt(tok.nextToken());
                conn[u].add(new Node(v, p));
            }

            cost = new int[N];
            Arrays.fill(cost, Integer.MAX_VALUE);
            dijkstra();
            removePath();
            Arrays.fill(cost, Integer.MAX_VALUE);
            dijkstra();

            bw.append(String.valueOf(cost[end] == Integer.MAX_VALUE ? -1 : cost[end])).append("\n");
        }
        bw.flush();
    }

    private static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        cost[start] = 0;
        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            if (cost[curr.to] < curr.cost) continue;
            for (Node next : conn[curr.to]) {
                if (next.removed) continue;
                int nextCost = cost[curr.to] + next.cost;
                if (cost[next.to] > nextCost) {
                    cost[next.to] = nextCost;
                    pq.offer(new Node(next.to, nextCost));
                }
            }
        }
    }

    private static void removePath() {
        boolean[] visited = new boolean[N];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(end);
        visited[end] = true;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int i = 0; i < N; i++) {
                if (cost[i] == Integer.MAX_VALUE) continue;
                for (Node next : conn[i]) {
                    if (next.to != curr || cost[i] + next.cost != cost[curr]) {
                        continue;
                    }
                    next.removed = true;
                    if (!visited[i]) {
                        visited[i] = true;
                        queue.offer(i);
                    }
                }
            }
        }
    }

    private static class Node implements Comparable<Node> {
        int to;
        int cost;
        boolean removed;

        Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
            this.removed = false;
        }

        @Override
        public int compareTo(Node node) {
            return this.cost - node.cost;
        }
    }
}
