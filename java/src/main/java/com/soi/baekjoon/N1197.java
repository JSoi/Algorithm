package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class N1197 {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int V = Integer.parseInt(input[0]);
        int E = Integer.parseInt(input[1]);
        PriorityQueue<Node> queue = new PriorityQueue<>();
        for (int e = 0; e < E; e++) {
            String[] line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]) - 1;
            int b = Integer.parseInt(line[1]) - 1;
            long w = Long.parseLong(line[2]);
            queue.offer(new Node(a, b, w));
        }
        long answer = 0;
        parent = new int[V];
        for (int p = 0; p < V; p++) {
            parent[p] = p;
        }
        int edgeCount = 0;
        while (!queue.isEmpty() && edgeCount < V - 1) {
            Node latest = queue.poll();
            if (findParent(latest.from) == findParent(latest.to)) {
                continue;
            }
            union(latest.from, latest.to);
            answer += latest.weight;
            edgeCount++;
        }
        System.out.println(answer);
    }

    private static void union(int a, int b) {
        int aRoot = findParent(a);
        int bRoot = findParent(b);
        if (aRoot != bRoot) {
            parent[bRoot] = aRoot;
        }
    }

    private static int findParent(int target) {
        if (parent[target] == target) return target;
        parent[target] = findParent(parent[target]);
        return parent[target];
    }

    static class Node implements Comparable<Node> {
        int from;
        int to;
        long weight;

        public Node(int from, int to, long weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node node) {
            return Long.compare(this.weight, node.weight);
        }
    }
}
