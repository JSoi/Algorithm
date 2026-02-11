package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ_1414 {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        parent = new int[n];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        int initalLen = 0;
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                int len = toNum(line.charAt(j));
                initalLen += len;
                if (len != 0 && i != j) {
                    pq.offer(new int[]{i, j, len});
                }
            }
        }
        int min = 0;
        int count = 0;

        while (!pq.isEmpty()) {
            int[] edge = pq.poll();
            int a = edge[0];
            int b = edge[1];
            int len = edge[2];
            if (union(a, b)) {
                min += len;
                count++;
            }
        }

        if (count == n - 1) {
            System.out.println(initalLen - min);
        } else {
            System.out.println(-1);
        }
    }

    static int toNum(char c) {
        if (c == '0') return 0;
        if (c >= 'a' && c <= 'z') return c - 'a' + 1;
        else return c - 'A' + 27;
    }

    static int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    static boolean union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa == pb) return false;
        parent[pa] = pb;
        return true;
    }
}
