package com.soi.baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_1719 {
    private static final int INF = Integer.MAX_VALUE;
    private static int[][] dist, firstSpot;
    private static List<int[]>[] conn;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        conn = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            conn[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            conn[x].add(new int[]{y, d});
            conn[y].add(new int[]{x, d});
        }
        // init
        dist = new int[n + 1][n + 1];
        firstSpot = new int[n + 1][n + 1];
        for (int[] d : dist) {
            Arrays.fill(d, INF);
        }
        for (int i = 1; i <= n; i++) {
            djikstra(i);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    bw.write("- ");
                } else {
                    bw.write(firstSpot[i][j] + " ");
                }
            }
            bw.write("\n");
        }
        bw.flush();
    }

    // circulate all nodes
    // O(V*logE)
    private static void djikstra(int start) {
        int[] first = new int[n + 1];
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        first[start] = start;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{start, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curNode = cur[0];
            int curDist = cur[1];
            if (dist[curNode] < curDist) {
                continue;
            }
            for (int[] nn : conn[curNode]) {
                int nextNode = nn[0];
                int nextDist = nn[1];
                if (curDist + nextDist < dist[nextNode]) {
                    first[nextNode] = curNode == start ? nextNode : first[curNode];
                    dist[nextNode] = curDist + nextDist;
                    pq.offer(new int[]{nextNode, curDist + nextDist});
                }
            }
        }
        System.arraycopy(first, 1, firstSpot[start], 1, n);
    }
}
