package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_24444 {
    private static List<Integer>[] conn;
    private static int n;
    private static BufferedReader br;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        conn = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            conn[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            conn[from].add(to);
            conn[to].add(from);
        }

        // sort asc
        for (int i = 1; i <= n; i++) {
            Collections.sort(conn[i]);
        }

        boolean[] visited = new boolean[n + 1];
        visited[start] = true;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);

        // answer
        int[] order = new int[n + 1];
        int count = 1;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            order[curr] = count++;
            for (int next : conn[curr]) {
                if (visited[next]) continue;
                visited[next] = true;
                queue.offer(next);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(order[i]).append("\n");
        }
        System.out.println(sb);
    }

}
