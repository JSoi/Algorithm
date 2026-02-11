package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_5972 {
    public static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        List<int[]>[] conn = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            conn[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(tok.nextToken());
            int b = Integer.parseInt(tok.nextToken());
            int c = Integer.parseInt(tok.nextToken());
            conn[a].add(new int[]{b, c});
            conn[b].add(new int[]{a, c});
        }

        // dijkstra
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1])); // {idx, cost}
        pq.offer(new int[]{1, 0});
        dist[1] = 0;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            if (curr[1] > dist[curr[0]]) continue;
            for (int[] neighbor : conn[curr[0]]) {
                int next = neighbor[0];
                int cost = neighbor[1];
                if (dist[next] <= dist[curr[0]] + cost) {
                    continue;
                }
                dist[next] = dist[curr[0]] + cost;
                pq.offer(new int[]{next, dist[curr[0]] + cost});
            }
        }
//        System.out.println(Arrays.toString(dist));
        System.out.println(dist[n]);
    }
}
