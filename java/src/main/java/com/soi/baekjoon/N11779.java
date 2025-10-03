package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class N11779 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        List<int[]>[] conn = IntStream.range(0, N).mapToObj(i -> new ArrayList()).toArray(List[]::new);
        for (int i = 0; i < M; i++) {
            StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(tok.nextToken()) - 1;
            int y = Integer.parseInt(tok.nextToken()) - 1;
            int c = Integer.parseInt(tok.nextToken());
            conn[x].add(new int[]{y, c});
        }
        StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(tok.nextToken()) - 1;
        int end = Integer.parseInt(tok.nextToken()) - 1;
//        for (List<int[]> ints : conn) {
//            System.out.println(ints.stream().map(Arrays::toString).collect(Collectors.joining(" ")));
//        }
        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        int[] prev = new int[N];
        Arrays.fill(prev, -1);

        dist[start] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0];
            int cost = cur[1];

            if (cost > dist[node]) continue;

            for (int[] edge : conn[node]) {
                int next = edge[0];
                int newCost = cost + edge[1];
                if (newCost < dist[next]) {
                    dist[next] = newCost;
                    prev[next] = node;
                    pq.offer(new int[]{next, newCost});
                }
            }
        }

        List<Integer> path = new ArrayList<>();
        for (int cur = end; cur != -1; cur = prev[cur]) {
            path.add(cur + 1);
        }
        Collections.reverse(path);

        StringBuilder sb = new StringBuilder();
        sb.append(dist[end]).append('\n');
        sb.append(path.size()).append('\n');
        for (int n : path) sb.append(n).append(' ');
        System.out.println(sb);
    }
}
