package com.soi.baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class N4803 {
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
            int treeCount = Math.toIntExact(IntStream.rangeClosed(1, n).map(a -> find(a))
                    .distinct().filter(b -> !hasCycle[b]).count());
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
        parent[Math.min(rA, rB)] = Math.max(rA, rB);
    }

    static int find(int x) {
        if (parent[x] == x)
            return x;
        int p = find(parent[x]);
        if (hasCycle[x] || hasCycle[p]) {
            hasCycle[x] = hasCycle[p] = true;
        }
        return parent[x] = p;
    }

    static String getInfoStr(int caseCount, int treeCount) {
        return switch (treeCount) {
            case 0 -> String.format("Case %d: No trees.", caseCount);
            case 1 -> String.format("Case %d: There is one tree.", caseCount);
            default -> String.format("Case %d: A forest of %d trees.", caseCount, treeCount);
        };
    }
}
