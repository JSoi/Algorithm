package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_18436 {
    private static int n;
    private static int[] segmentTree; // 짝수 카운트 세그먼트 트리
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        segmentTree = new int[4 * n];
        init(1, 0, n - 1);
        int q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int type = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            switch (type) {
                case 1:
                    // 업데이트
                    int updateValue = to + 1;
                    update(from, updateValue);
                    break;
                case 2:
                    // 짝수 카운트
                    sb.append(query(1, 0, n - 1, from, to)).append("\n");
                    break;
                case 3:
                    // 홀수 카운트
                    sb.append((to - from + 1) - query(1, 0, n - 1, from, to)).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }

    private static int query(int node, int from, int to, int left, int right) {
        if (right < from || to < left) return 0;
        if (left <= from && to <= right) return segmentTree[node];
        int mid = (from + to) / 2;
        return query(2 * node, from, mid, left, right) + query(2 * node + 1, mid + 1, to, left, right);
    }

    private static void update(int idx, int value) {
        arr[idx] = value;
        update(1, idx, 0, n - 1);
    }

    private static void update(int node, int idx, int start, int end) {
        if (start == end) {
            segmentTree[node] = arr[start] % 2 == 0 ? 1 : 0;
            return;
        }
        int mid = (start + end) / 2;
        if (idx <= mid) {
            update(2 * node, idx, start, mid);
        } else {
            update(2 * node + 1, idx, mid + 1, end);
        }
        segmentTree[node] = segmentTree[2 * node] + segmentTree[2 * node + 1];
    }

    private static void init(int node, int start, int end) {
        if (start == end) {
            segmentTree[node] = arr[start] % 2 == 0 ? 1 : 0;
            return;
        }
        int mid = (start + end) / 2;
        init(2 * node, start, mid);
        init(2 * node + 1, mid + 1, end);
        segmentTree[node] = segmentTree[2 * node] + segmentTree[2 * node + 1];
    }
}
