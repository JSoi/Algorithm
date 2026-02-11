package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1647 {
    private static int[] root;
    private static int n, size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        size = n;
        int m = Integer.parseInt(st.nextToken());
        root = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            root[i] = i;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        for (int i = 1; i <= m; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            pq.offer(input);
        }
        int ans = 0;
        while (!pq.isEmpty() && size > 2) {
            int[] curr = pq.poll();
            boolean u = union(curr[0], curr[1]);
            ans += u ? curr[2] : 0;
        }
        System.out.println(ans);
    }

    private static int find(int a) {
        if (root[a] == a) return a;
        return root[a] = find(root[a]);
    }

    private static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot == bRoot) {
            return false;
        }
        size--;
        root[bRoot] = aRoot;
        return true;
    }
}
