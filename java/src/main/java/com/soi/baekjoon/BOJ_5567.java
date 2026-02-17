package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_5567 {
    public static final int MAX = Integer.MAX_VALUE;
    private static List<Integer>[] conn;
    private static int n;
    private static boolean[] visit;
    private static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        conn = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            conn[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            String[] line = br.readLine().split(" ");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);
            conn[x].add(y);
            conn[y].add(x);
        }

        dist = new int[n + 1];
        visit = new boolean[n + 1];
        Arrays.fill(dist, MAX);
        bfs();
        int answer = 0;
        for (int i = 2; i <= n; i++) {
            if (dist[i] <= 2) answer++;
        }
        System.out.println(answer);

    }

    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1, 0}); // {idx, dist}
        visit[1] = true;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            if (dist[curr[0]] < curr[1]) continue;
            for (int next : conn[curr[0]]) {
                if (visit[next]) continue;
                visit[next] = true;
                dist[next] = curr[1] + 1;
                queue.offer(new int[]{next, curr[1] + 1});
            }
        }

    }
}
