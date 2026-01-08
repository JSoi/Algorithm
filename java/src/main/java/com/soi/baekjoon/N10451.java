package com.soi.baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N10451 {
    private static int[] next;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cases = Integer.parseInt(br.readLine());
        while (cases-- > 0) {
            n = Integer.parseInt(br.readLine());
            next = new int[n + 1];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 1; i <= n; i++) {
                int num = Integer.parseInt(st.nextToken());
                next[i] = num;
            }
            int cycleCount = 0;
            boolean[] visited = new boolean[n + 1];
            visited[0] = true;
            for (int i = 1; i <= n; i++) {
                if (visited[i]) {
                    continue;
                }
                Queue<Integer> queue = new LinkedList<>();
                cycleCount++;
                queue.offer(i);
                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    int nextNode = next[node];
                    if (visited[nextNode]) {
                        continue;
                    }
                    visited[nextNode] = true;
                    queue.offer(nextNode);
                }
            }
            bw.write(cycleCount + "\n");
        }
        bw.flush();
    }
}
