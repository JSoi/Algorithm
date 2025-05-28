package com.soi.baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class N11438 {
    static int[] depth;
    static int LOG;
    static int[][] parent;
    static int nodeCount;
    static List<List<Integer>> tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        nodeCount = Integer.parseInt(br.readLine());
        LOG = (int) Math.ceil(Math.log(nodeCount) / Math.log(2)) + 1;
        parent = new int[nodeCount + 1][LOG];
        depth = new int[nodeCount + 1];
        tree = new ArrayList<>();

        for (int i = 0; i <= nodeCount; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < nodeCount - 1; i++) {
            String[] line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            tree.get(a).add(b);
            tree.get(b).add(a);
        }
        depth[0] = 1;
        setDepth(1, 0);

        int questionCount = Integer.parseInt(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int q = 0; q < questionCount; q++) {
            String[] line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            bw.append(String.valueOf(lca(a, b))).append("\n");
        }
        bw.flush();
    }

    private static void setDepth(int current, int root) {
        parent[current][0] = root; // 직접 조상
        for (int i = 1; i < LOG; i++) {
            parent[current][i] = parent[parent[current][i - 1]][i - 1];
        }
        for (int next : tree.get(current)) {
            if (next != root) {
                depth[next] = depth[current] + 1;
                setDepth(next, current);
            }
        }
    }

    static int lca(int a, int b) {
        if (depth[a] < depth[b]) { // a depth 가 더 깊도록 설정
            int temp = a;
            a = b;
            b = temp;
        }
        for (int i = LOG - 1; i >= 0; i--) {
            if (depth[a] - (1 << i) >= depth[b]) {
                a = parent[a][i];
            }
        }
        if (a == b) return a;
        for (int i = LOG - 1; i >= 0; i--) {
            if (parent[a][i] != parent[b][i]) {
                a = parent[a][i];
                b = parent[b][i];
            }
        }
        return parent[a][0];
    }
}
