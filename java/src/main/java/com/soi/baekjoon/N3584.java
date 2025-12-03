package com.soi.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class N3584 {
    static int n;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {
            n = Integer.parseInt(br.readLine());
            init();
            for (int i = 0; i < n - 1; i++) {
                StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
                int u = Integer.parseInt(tok.nextToken());
                int v = Integer.parseInt(tok.nextToken());
                parent[v] = u;
            }
            StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(tok.nextToken());
            int v = Integer.parseInt(tok.nextToken());
            bw.write(findCommonParent(u, v) + "\n");
        }
        bw.flush();
    }

    static void init() {
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
    }

    static int findCommonParent(int a, int b) {
        boolean[] visit = new boolean[n + 1];
        findParent(a, visit);
        return findParent(b, visit);
    }

    static int findParent(int target, boolean[] visited) {
        if (visited[target]) return target;
        visited[target] = true;
        int p = parent[target];
        if (p == target || visited[p]) {
            return p;
        }
        return findParent(p, visited);
    }
}
