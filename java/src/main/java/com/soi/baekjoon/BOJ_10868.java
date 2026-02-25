package com.soi.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_10868 {
    private static long[] segmentTree;
    private static long[] arr;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        int queryCount = Integer.parseInt(st.nextToken());

        arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        segmentTree = new long[n * 4];
        buildTree(0, n - 1, 1);
        // node 1 = root

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int q = 0; q < queryCount; q++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            bw.write(query(start, end) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void buildTree(int start, int end, int node) {
        if (start == end) {
            segmentTree[node] = arr[start];
            return;
        }
        int mid = (start + end) / 2;
        buildTree(start, mid, node * 2); // left child node
        buildTree(mid + 1, end, node * 2 + 1); // right child node
        segmentTree[node] = Math.min(segmentTree[node * 2], segmentTree[node * 2 + 1]);
    }

    public static long query(int left, int right) {
        return query(0, n - 1, 1, left, right);
    }

    private static long query(int start, int end, int node, int left, int right) {
        if (right < start || end < left) {
            return Long.MAX_VALUE;
        }
        if (left <= start && end <= right) {
            return segmentTree[node];
        }
        int mid = (start + end) / 2;
        long leftMin = query(start, mid, node * 2, left, right);
        long rightMin = query(mid + 1, end, node * 2 + 1, left, right);
        return Math.min(leftMin, rightMin);
    }
}
