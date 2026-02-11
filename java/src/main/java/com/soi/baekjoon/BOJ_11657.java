package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_11657 {
    public static final long INF = Long.MAX_VALUE;
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, M;
    private static long[] dist;
    private static List<long[]> edges;

    public static void main(String[] args) throws IOException {
        init();
        // N-1개의 간선을 거치는 모든 최단 경로
        for (int i = 0; i < N; i++) {
            for (long[] e : edges) {
                int from = (int) e[0], to = (int) e[1];
                long cost = e[2];
                if (dist[from] != INF && dist[to] > dist[from] + cost) {
                    dist[to] = dist[from] + cost;
                }
            }
        }
        // 음수 사이클 확인
        for (long[] e : edges) {
            int from = (int) e[0], to = (int) e[1];
            long cost = e[2];
            if (dist[from] != INF && dist[to] > dist[from] + cost) {
                System.out.println(-1);
                return;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N; i++) {
            sb.append(dist[i] == INF ? -1 : dist[i]).append("\n");
        }
        System.out.print(sb);
    }

    private static void init() throws IOException {
        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);
        edges = new ArrayList<>();

        dist = new long[N];
        Arrays.fill(dist, INF);
        dist[0] = 0;

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()) - 1;
            int B = Integer.parseInt(st.nextToken()) - 1;
            int C = Integer.parseInt(st.nextToken());
            edges.add(new long[]{A, B, C});
        }
    }
}
