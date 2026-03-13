package com.soi.baekjoon;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_3176 {
    private static int[][] min;
    private static int[][] max;
    private static int n;
    private static Map<Integer, Integer>[] conn;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        conn = new Map[n + 1];
        for (int i = 1; i <= n; i++) {
            conn[i] = new HashMap<>();
        }
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            conn[a].put(b, c);
            conn[b].put(a, c);
        }
        min = new int[n + 1][n + 1];
        max = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                min[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 1; i <= n; i++) {
            dfs(i, i, 0, Integer.MAX_VALUE, 0);
        }

        int question = Integer.parseInt(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int q = 0; q < question; q++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bw.write(min[a][b] + " " + max[a][b] + "\n");
        }
        bw.flush();
    }

    private static void dfs(int start, int cur, int parent, int curMin, int curMax) {
        min[start][cur] = curMin;
        max[start][cur] = curMax;
        for (Map.Entry<Integer, Integer> e : conn[cur].entrySet()) {
            int next = e.getKey();
            int cost = e.getValue();
            if (next == parent) continue;
            int nextMin = (cur == start) ? cost : Math.min(curMin, cost);
            int nextMax = (cur == start) ? cost : Math.max(curMax, cost);
            dfs(start, next, cur, nextMin, nextMax);
        }
    }
}
