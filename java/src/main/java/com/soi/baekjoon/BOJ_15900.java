package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_15900 {
    private static int[] count;
    private static List<Integer>[] conn;
    private static boolean[] visited;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        count = new int[n + 1];
        conn = new List[n + 1];
        visited = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            conn[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            String[] line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            conn[a].add(b);
            conn[b].add(a);
        }

        // BFS
        Queue<int[]> queue = new ArrayDeque<>();
        visited[1] = true;
        queue.offer(new int[]{1, 0});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int curNode = poll[0];
            int curCount = poll[1];
            count[curNode] = curCount;
            for (int next : conn[curNode]) {
                if (visited[next]) continue;
                visited[next] = true;
                queue.add(new int[]{next, curCount + 1});
            }
        }
        int totalMove = 0;
        for (int i = 2; i <= n; i++) {
            if (conn[i].size() == 1) {
                totalMove += count[i];
            }
        }
        System.out.println(totalMove % 2 == 1 ? "Yes" : "No");
    }
}
