package com.soi.baekjoon;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class BOJ_6497 {
    static int N, M;
    static int[] root;
    static boolean[] visited;
    static HashMap<Integer, Set<Edge>> conn;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        while (true) {
            String[] nm = br.readLine().split(" ");
            N = Integer.parseInt(nm[0]);
            M = Integer.parseInt(nm[1]);
            if (N == 0 && M == 0) {
                bw.flush();
                bw.close();
                break;
            }
            testCase();
        }
    }

    private static void testCase() throws IOException {
        root = new int[N];
        conn = new HashMap<>();
        visited = new boolean[N];

        for (int r = 0; r < root.length; r++) {
            root[r] = r;
            conn.put(r, new HashSet<>());
        }

        long initialDist = 0;
        PriorityQueue<Edge> edges = new PriorityQueue<>();
        for (int i = 0; i < M; i++) {
            String[] line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            int d = Integer.parseInt(line[2]);
            conn.get(a).add(new Edge(a, b, d));
            conn.get(b).add(new Edge(b, a, d));
            edges.add(new Edge(a, b, d));
            initialDist += d;
        }

        long secondDist = 0;
        while (!edges.isEmpty()) {
            Edge e = edges.poll();
            int from = e.from;
            int to = e.to;
            if (findParent(from) != findParent(to)) {
                union(from, to);
                secondDist += (long) e.distance;
            }
        }
        bw.append(String.valueOf(initialDist - secondDist)).append("\n");
    }

    private static void union(int a, int b) {
        int rootA = findParent(a);
        int rootB = findParent(b);
        root[rootB] = rootA;
    }

    private static int findParent(int a) {
        if (root[a] == a) {
            return a;
        }
        return root[a] = findParent(root[a]);
    }

    private record Edge(int from, int to, double distance) implements Comparable<Edge> {

        @Override
            public int compareTo(Edge edge) {
                return Double.compare(this.distance, edge.distance);
            }
        }
}
