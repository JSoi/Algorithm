package com.soi.baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N2357 {
    private static int n;
    private static long[] arr, minTree, maxTree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        minTree = new long[4 * n];
        maxTree = new long[4 * n];
        Arrays.fill(minTree, Long.MAX_VALUE);
        buildTree(minTree, 0, n - 1, 1, false);
        buildTree(maxTree, 0, n - 1, 1, true);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            bw.write(query(from, to, false) + " " + query(from, to, true) + "\n");
        }
        bw.flush();
    }

    private static void buildTree(long[] tree, int from, int to, int node, boolean isMax) {
        if (from == to) {
            tree[node] = arr[from];
            return;
        }
        int mid = (from + to) / 2;
        buildTree(tree, from, mid, node * 2, isMax);
        buildTree(tree, mid + 1, to, node * 2 + 1, isMax);
        tree[node] = isMax ? Math.max(tree[node * 2], tree[node * 2 + 1]) : Math.min(tree[node * 2], tree[node * 2 + 1]);
    }

    private static long query(int left, int right, boolean isMax) {
        return query(isMax, 0, n - 1, 1, left, right);
    }

    private static long query(boolean isMax, int start, int end, int node, int left, int right) {
        if (right < start || end < left) {
            return isMax ? 0 : Long.MAX_VALUE;
        }
        if (left <= start && end <= right) {
            return isMax ? maxTree[node] : minTree[node];
        }
        int mid = (start + end) / 2;
        long leftValue = query(isMax, start, mid, node * 2, left, right);
        long rightValue = query(isMax, mid + 1, end, node * 2 + 1, left, right);
        return isMax ? Math.max(leftValue, rightValue) : Math.min(leftValue, rightValue);
    }
}
