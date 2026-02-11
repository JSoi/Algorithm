package com.soi.baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1761 {
    static List<Edge>[] connections;
    private static int[] root, depth, distance;
    private static boolean[] visited;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        root = new int[n + 1];
        distance = new int[n + 1];
        connections = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            connections[i] = new ArrayList();
            root[i] = i;
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            connections[a].add(new Edge(b, c));
            connections[b].add(new Edge(a, c));
        }

        // root는 1로 지정
        visited = new boolean[n + 1];
        depth = new int[n + 1];
        visited[1] = true;
        buildTree(1, 0);
//        System.out.println(Arrays.toString(distance));
//        System.out.println(Arrays.toString(depth));
//        System.out.println(Arrays.toString(root));
        int m = Integer.parseInt(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bw.write(findDistance(a, b) + "\n");
        }
        bw.flush();
    }

    private static void buildTree(int parent, int d) {
        for (Edge e : connections[parent]) {
            // update distance
            int next = e.to;
            if (visited[next]) continue;
            visited[next] = true;
            distance[next] = distance[parent] + e.cost;
            depth[next] = depth[parent] + 1;
            root[next] = parent;
            buildTree(next, d + 1);
        }
    }

    private static int findParent(int a, int b) {
        // search until same depth
        int aa = a;
        int bb = b;
        int depthA, depthB;
        while (aa != bb) {
            depthA = depth[aa];
            depthB = depth[bb];
            if (depthA < depthB) {
                bb = root[bb];
            } else if (depthA > depthB) {
                aa = root[aa];
            } else {
                aa = root[aa];
                bb = root[bb];
            }
        }
        return aa;
    }

    private static int findDistance(int a, int b) {
        int distA = distance[a];
        int distB = distance[b];
        return distA + distB - 2 * distance[findParent(a, b)];
    }

    private static class Edge {
        int to;
        int cost;

        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
}
