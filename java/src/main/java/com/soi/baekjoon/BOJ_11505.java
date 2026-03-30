package com.soi.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_11505 {
    private static final long MOD = 1_000_000_007L;
    private static int n;
    private static long[] segmentTree;
    private static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        int change = Integer.parseInt(st.nextToken());
        int query = Integer.parseInt(st.nextToken());

        arr = new long[n];
        segmentTree = new long[n * 4 + 1];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        buildTree(0, n - 1, 1);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < query + change; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == 1) { // change
                update(b - 1, c);
            } else {
                bw.write(query(b - 1, c - 1) + "\n");
            }
        }
        bw.flush();
    }

    private static void buildTree(int start, int end, int node) {
        if (start == end) {
            segmentTree[node] = arr[start];
            return;
        }
        int mid = (start + end) / 2;
        buildTree(start, mid, node * 2);
        buildTree(mid + 1, end, node * 2 + 1);
        segmentTree[node] = ((segmentTree[node * 2] % MOD) * (segmentTree[node * 2 + 1] % MOD)) % MOD;
    }

    private static void update(int idx, int value) {
        update(0, n - 1, 1, idx, value);
    }

    private static void update(int start, int end, int node, int idx, long value) {
        if (start == end) {
            segmentTree[node] = value;
            arr[idx] = value;
            return;
        }
        int mid = (start + end) / 2;
        if (idx <= mid) {
            update(start, mid, node * 2, idx, value);
        } else {
            update(mid + 1, end, node * 2 + 1, idx, value);
        }
        segmentTree[node] = ((segmentTree[node * 2] % MOD) * (segmentTree[node * 2 + 1] % MOD)) % MOD;
    }

    public static long query(int left, int right) {
        return query(0, n - 1, 1, left, right);
    }

    private static long query(int start, int end, int node, int left, int right) {
        if (right < start || end < left) {
            return 1;
        }
        if (left <= start && end <= right) {
            return segmentTree[node];
        }
        int mid = (start + end) / 2;
        long leftMul = query(start, mid, node * 2, left, right);
        long rightMul = query(mid + 1, end, node * 2 + 1, left, right);
        return ((leftMul % MOD) * (rightMul % MOD) % MOD);
    }
}
