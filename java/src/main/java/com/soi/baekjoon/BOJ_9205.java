package com.soi.baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9205 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] conn = new int[n + 2][2];
            for (int i = 0; i < n + 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                conn[i][0] = Integer.parseInt(st.nextToken());
                conn[i][1] = Integer.parseInt(st.nextToken());
            }
            TestCase tc = new TestCase(conn);
            bw.append(tc.isAbleToArrive() ? "happy" : "sad").append("\n");
        }
        bw.flush();
    }

    private static class TestCase {
        int start;
        int end;
        int v;
        boolean[] visit;
        int[][] conn;

        private TestCase(int[][] conn) {
            start = 0;
            v = conn.length;
            end = v - 1;
            this.conn = conn;
            visit = new boolean[v];
        }

        public boolean isAbleToArrive() {
            Queue<Integer> queue = new LinkedList<>();
            visit[start] = true;
            queue.offer(start);
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                if (cur == end) {
                    return true;
                }
                for (int i = 0; i < v; i++) {
                    if (visit[i]) {
                        continue;
                    }
                    int dist = Math.abs(conn[cur][0] - conn[i][0]) + Math.abs(conn[cur][1] - conn[i][1]);
                    if (dist <= 1000) {
                        visit[i] = true;
                        queue.offer(i);
                    }
                }
            }
            return false;
        }
    }
}
