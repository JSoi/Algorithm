package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N1504 {
    private static final int MAX = Integer.MAX_VALUE;
    static int[][] dist;
    static List<int[]>[] conn;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NE = br.readLine().split(" ");
        int N = Integer.parseInt(NE[0]);
        int E = Integer.parseInt(NE[1]);
        dist = new int[N][4]; // from 0 to iox
        conn = new List[N];
        for (int i = 0; i < N; i++) {
            conn[i] = new ArrayList<>();
        }
        for (int[] d : dist) {
            Arrays.fill(d, MAX);
        }
        for (int i = 0; i < E; i++) {
            String[] line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]) - 1;
            int b = Integer.parseInt(line[1]) - 1;
            int c = Integer.parseInt(line[2]);
            conn[a].add(new int[]{b, c});
            conn[b].add(new int[]{a, c});
        }
        String[] mustVisit = br.readLine().split(" ");
        int mustVisit1 = Integer.parseInt(mustVisit[0]) - 1;
        int mustVisit2 = Integer.parseInt(mustVisit[1]) - 1;

        int[] from1 = dijkstra(0);
        int[] fromV1 = dijkstra(mustVisit1);
        int[] fromV2 = dijkstra(mustVisit2);

        long route1 = (long) from1[mustVisit1] + fromV1[mustVisit2] + fromV2[N - 1];
        long route2 = (long) from1[mustVisit2] + fromV2[mustVisit1] + fromV1[N - 1];
        long answer = Math.min(route1, route2);
        System.out.println((answer >= MAX) ? -1 : answer);
    }

    static int[] dijkstra(int start) {
        int n = conn.length;
        int[] dist = new int[n];
        Arrays.fill(dist, MAX);
        dist[start] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{start, 0});
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int now = current[0];
            int cost = current[1];
            if (cost > dist[now]) continue;
            for (int[] next : conn[now]) {
                int nextNode = next[0];
                int nextCost = cost + next[1];
                if (nextCost < dist[nextNode]) {
                    dist[nextNode] = nextCost;
                    pq.offer(new int[]{nextNode, nextCost});
                }
            }
        }
        return dist;
    }
}
