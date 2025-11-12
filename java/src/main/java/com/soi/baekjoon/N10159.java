package com.soi.baekjoon;

import java.io.*;
import java.util.*;

public class N10159 {
    // 18:00 - 18:17
    private static boolean[][] visit;
    private static List<Integer>[] conn;
    private static int n;

    public static void main(String[] args) throws IOException {
        init();
        // bfs
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < n; i++) {
            bfs(i);
        }
        for (int i = 0; i < n; i++) {
            int count = n;
            for (int j = 0; j < n; j++) {
                if (visit[i][j] || visit[j][i]) {
                    count--;
                }
            }
            bw.append(String.valueOf(count)).append("\n");
        }
        bw.flush();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        visit = new boolean[n][n];
        conn = new List[n];
        for (int i = 0; i < n; i++) {
            conn[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            // a > b
            StringTokenizer tok = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(tok.nextToken()) - 1;
            int b = Integer.parseInt(tok.nextToken()) - 1;
            conn[a].add(b);
        }
    }

    private static void bfs(int start) {
        visit[start][start] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int c : conn[curr]) {
                if (!visit[start][c]) {
                    queue.offer(c);
                    visit[start][c] = true;
                }
            }
        }
    }
}
