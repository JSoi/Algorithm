package com.soi.baekjoon;

import java.util.Scanner;

public class BOJ_14244 {
    private static int[] parent;
    private static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        parent = new int[n];
        boolean[] isLeaf = new boolean[n];
        isLeaf[0] = true;
        int leafNode = 0;
        for (int i = 1; i < n; i++) {
            if (m == 0) {
                parent[i] = leafNode;
            } else { // need more leaf
                parent[i] = parent[leafNode];
                m--;
            }
            leafNode = i;
        }
        System.out.println(printTree());
    }

    private static String printTree() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n; i++) {
            sb.append(parent[i]).append(" ").append(i).append("\n");
        }
        return sb.toString();
    }
}
