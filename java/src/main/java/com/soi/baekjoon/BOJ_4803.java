package com.soi.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_4803 {
    static int[] parent;
    static boolean[] hasCycle;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;
        int caseCount = 0;
        while (!(input = br.readLine()).equals("0 0")) {
            caseCount++;
            StringTokenizer tok = new StringTokenizer(input, " ");
            n = Integer.parseInt(tok.nextToken());
            parent = new int[n + 1];
            hasCycle = new boolean[n + 1];
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
            }
            int m = Integer.parseInt(tok.nextToken());

            for (int i = 0; i < m; i++) {
                tok = new StringTokenizer(br.readLine(), " ");
                int u = Integer.parseInt(tok.nextToken());
                int v = Integer.parseInt(tok.nextToken());
                union(u, v);
//                System.out.println(Arrays.toString(parent));
            }
            int treeCount = 0;
            boolean[] rootVisited = new boolean[n + 1];
            for (int i = 1; i <= n; i++) {
                int r = find(i);
                if (!rootVisited[r]) {
                    rootVisited[r] = true;
                    if (!hasCycle[r]) treeCount++;
                }
            }
            bw.write(getInfoStr(caseCount, treeCount) + "\n");
        }
        bw.flush();
    }

    static void union(int a, int b) {
        int rA = find(a);
        int rB = find(b);
        if (rA == rB) {
            hasCycle[rA] = true;
            return;
        }
        parent[rB] = rA;
        if (hasCycle[rA] || hasCycle[rB]) {
            hasCycle[rA] = true;
        }
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static String getInfoStr(int caseCount, int treeCount) {
        return switch (treeCount) {
            case 0 -> String.format("Case %d: No trees.", caseCount);
            case 1 -> String.format("Case %d: There is one tree.", caseCount);
            default -> String.format("Case %d: A forest of %d trees.", caseCount, treeCount);
        };
    }
}
