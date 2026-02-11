package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10775 {
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int gateCount = Integer.parseInt(br.readLine());
        int planeCount = Integer.parseInt(br.readLine());

        parent = new int[gateCount + 1];
        for (int i = 0; i <= gateCount; i++) {
            parent[i] = i;
        }

        int count = 0;
        for (int i = 0; i < planeCount; i++) {
            int gateLimit = Integer.parseInt(br.readLine());
            int dock = find(gateLimit);
            if (dock == 0) break;
            union(dock - 1, dock);
            count++;
        }

        System.out.println(count);
    }

    private static int find(int n) {
        if (parent[n] == n) return n;
        return parent[n] = find(parent[n]);
    }

    private static void union(int a, int b) {
        parent[find(b)] = find(a);
    }
}
