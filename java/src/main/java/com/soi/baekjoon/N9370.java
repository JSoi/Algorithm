package com.soi.baekjoon;

import java.io.*;
import java.util.*;

public class N9370 {
    public static final int INF = Integer.MAX_VALUE;
    private static int n, m, t;
    private static int s, g, h;
    private static int[][] dist;
    private static List<int[]>[] conn;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {
            StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(tok.nextToken());
            m = Integer.parseInt(tok.nextToken());
            t = Integer.parseInt(tok.nextToken());
            tok = new StringTokenizer(br.readLine(), " ");
            s = Integer.parseInt(tok.nextToken()) - 1;
            g = Integer.parseInt(tok.nextToken()) - 1;
            h = Integer.parseInt(tok.nextToken()) - 1;
            conn = new List[n];
            for (int i = 0; i < n; i++) {
                conn[i] = new ArrayList<>();
            }
            List<Integer> candidates = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                tok = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(tok.nextToken()) - 1;
                int y = Integer.parseInt(tok.nextToken()) - 1;
                int cost = Integer.parseInt(tok.nextToken());
                conn[x].add(new int[]{y, cost});
                conn[y].add(new int[]{x, cost});
            }

            for (int i = 0; i < t; i++) {
                candidates.add(Integer.parseInt(br.readLine()) - 1);
            }
            Collections.sort(candidates);
            dijkstra();
            for (int c : candidates) {
                if (dist[c][1] != INF && dist[c][1] <= dist[c][0]) {
                    bw.append(String.valueOf(c + 1)).append(" ");
                }
            }
            bw.append("\n");
        }
        bw.flush();
    }

    private static void dijkstra() {
        PriorityQueue<Destination> pq = new PriorityQueue<>();
        pq.offer(new Destination(s, 0, false));
        dist = new int[n][2];
        for (int i = 0; i < n; i++) Arrays.fill(dist[i], INF);
        dist[s][0] = 0;

        while (!pq.isEmpty()) {
            Destination curr = pq.poll();
            int idx = curr.visitShortCut ? 1 : 0;
            if (curr.cost > dist[curr.to][idx]) continue;
            for (int[] c : conn[curr.to]) {
                boolean didVisit = curr.visitShortCut ||
                        (curr.to == g && c[0] == h) ||
                        (curr.to == h && c[0] == g);
                int nv = didVisit ? 1 : 0;
                int nC = curr.cost + c[1];
                if (nC < dist[c[0]][nv]) {
                    dist[c[0]][nv] = nC;
                    pq.offer(new Destination(c[0], nC, didVisit));
                }
            }
        }
    }

    private static class Destination implements Comparable<Destination> {
        @Override
        public int compareTo(Destination other) {
            return this.cost - other.cost;
        }

        int to;
        int cost;
        boolean visitShortCut;

        public Destination(int to, int cost, boolean visitShortCut) {
            this.to = to;
            this.cost = cost;
            this.visitShortCut = visitShortCut;
        }
    }
}
