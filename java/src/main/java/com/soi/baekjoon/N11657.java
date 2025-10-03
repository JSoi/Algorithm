package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class N11657 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        List<int[]> lists = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()) - 1;
            int B = Integer.parseInt(st.nextToken()) - 1;
            int C = Integer.parseInt(st.nextToken());
            lists.add(new int[]{A, B, C});
        }
        for (int i = 0; i < N; i++) {
            for (int[] conn : lists) {
                int from = conn[0];
                int to = conn[1];
                int cost = conn[2];
                if (dist[from] != Integer.MAX_VALUE && dist[to] > dist[from] + cost) {
                    dist[to] = dist[from] + cost;
                }
                if (dist[to] < 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N; i++) {
            sb.append(dist[i] == Integer.MAX_VALUE ? -1 : dist[i]).append("\n");
        }
        System.out.print(sb);
    }
}
