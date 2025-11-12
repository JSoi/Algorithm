package com.soi.baekjoon;

import java.io.*;
import java.util.*;

public class N1854 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(tok.nextToken());
        int M = Integer.parseInt(tok.nextToken());
        int K = Integer.parseInt(tok.nextToken());

        List<int[]>[] conn = new List[N + 1];
        List<Integer>[] dist = new List[N + 1];
        for (int i = 0; i <= N; i++) {
            conn[i] = new ArrayList<>();
            dist[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            tok = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(tok.nextToken());
            int y = Integer.parseInt(tok.nextToken());
            int z = Integer.parseInt(tok.nextToken());
            conn[x].add(new int[]{y, z});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{1, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curNode = cur[0];
            int curDist = cur[1];
            if (dist[curNode].size() >= K) continue;
            dist[curNode].add(curDist);
            for (int[] con : conn[curNode]) {
                pq.offer(new int[]{con[0], curDist + con[1]});
            }
        }
//        for (List<Integer> integers : dist) {
//            System.out.println(integers);
//        }
        for (int i = 1; i <= N; i++) {
            if (dist[i].size() < K) {
                bw.append(String.valueOf(-1)).append('\n');
            } else {
                bw.append(String.valueOf(dist[i].get(K - 1))).append('\n');
            }
        }
        bw.flush();
    }
}
