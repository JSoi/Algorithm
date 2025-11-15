package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N6549 {
    static int[] height, tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) break;

            height = new int[n];
            for (int i = 0; i < n; i++) {
                height[i] = Integer.parseInt(st.nextToken());
            }
            tree = new int[n * 4];
            init(1, 0, n - 1);
            System.out.println(getMaxArea(0, n - 1));
        }
    }

    static int init(int node, int start, int end) {
        if (start == end) return tree[node] = start;
        int mid = (start + end) / 2;
        return tree[node] = Math.min(init(node * 2, start, mid), init(node * 2 + 1, mid + 1, end));
    }

    static int query(int node, int start, int end, int l, int r) {
        if (r < start || end < l) return -1;
        if (l <= start && end <= r) return tree[node];

        int mid = (start + end) / 2;
        int leftIdx = query(node * 2, start, mid, l, r);
        int rightIdx = query(node * 2 + 1, mid + 1, end, l, r);

        if (leftIdx == -1) return rightIdx;
        if (rightIdx == -1) return leftIdx;
        return (height[leftIdx] < height[rightIdx]) ? leftIdx : rightIdx;
    }

    static long getMaxArea(int left, int right) {
        if (left > right) return 0;
        int minIdx = query(1, 0, height.length - 1, left, right);
        long area = (long) height[minIdx] * (right - left + 1);

        long leftArea = getMaxArea(left, minIdx - 1);
        long rightArea = getMaxArea(minIdx + 1, right);

        return Math.max(area, Math.max(leftArea, rightArea));
    }
}
