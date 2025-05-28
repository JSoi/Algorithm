package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N1916 {
    private static final int MAX = Integer.MAX_VALUE;
    private static int[] dist;
    private static HashMap<Integer, List<Node>> connMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cityCount = Integer.parseInt(br.readLine());
        int costInfoCount = Integer.parseInt(br.readLine());
        dist = new int[cityCount]; // array that already computed for min cost
        Arrays.fill(dist, MAX);
        connMap = new HashMap<>();
        for (int i = 0; i < cityCount; i++) {
            connMap.put(i, new ArrayList<>());
        }
        for (int c = 0; c < costInfoCount; c++) {
            int[] cost = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
            connMap.get(cost[0] - 1).add(new Node(cost[1] - 1, cost[2]));
        }
        int[] fromTo = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int answer = dijkstra(fromTo[0] - 1, fromTo[1] - 1);
        System.out.println(answer);
    }

    public static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[dist.length];
        pq.offer(new Node(start, 0));
        dist[start] = 0;
        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            int cur = curNode.end;
            if (visited[cur]) {
                continue;
            }
            visited[cur] = true;
            for (Node node : connMap.get(cur)) {
                if (visited[node.end] || dist[cur] == MAX || dist[node.end] <= dist[cur] + node.weight) {
                    continue;
                }
                dist[node.end] = Math.min(dist[node.end], dist[cur] + node.weight);
                pq.add(new Node(node.end, dist[node.end]));
            }
        }
        return dist[end];
    }


    private static class Node implements Comparable<Node> {
        int end;
        int weight;

        Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node other) {
            return weight - other.weight;
        }
    }
}
