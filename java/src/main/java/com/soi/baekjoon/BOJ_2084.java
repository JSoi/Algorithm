package com.soi.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2084 {
    static int n;
    static int[] degree;
    static boolean[][] adj;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        degree = new int[n];
        int total = 0;
        for (int i = 0; i < n; i++) {
            degree[i] = sc.nextInt();
            total += degree[i];
            if (degree[i] >= n) {
                System.out.println(-1);
                return;
            }
        }
        if (total % 2 != 0) { // 검사 확인
            System.out.println(-1);
            return;
        }

        if (isValidGraph()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    sb.append(adj[i][j] ? "1 " : "0 ");
                }
                sb.append("\n");
            }
            System.out.print(sb);
        } else {
            System.out.println(-1);
        }
    }

    static boolean isValidGraph() {
        adj = new boolean[n][n];
        int[][] nodes = new int[n][2]; // [degree, index]
        for (int i = 0; i < n; i++) {
            nodes[i][0] = degree[i];
            nodes[i][1] = i;
        }

        while (true) {
            Arrays.sort(nodes, (a, b) -> b[0] - a[0]); // degree 내림차순
            if (nodes[0][0] == 0) break;
            int d = nodes[0][0];
            for (int i = 1; i <= d; i++) {
                if (nodes[i][0] == 0) return false;
                int u = nodes[0][1];
                int v = nodes[i][1];
                adj[u][v] = adj[v][u] = true;
                nodes[i][0]--;
            }
            nodes[0][0] = 0;
        }
        return true;
    }
}
