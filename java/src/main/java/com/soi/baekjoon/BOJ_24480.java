package com.soi.baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_24480 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static List<Integer>[] conn;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        conn = new List[n + 1];
        boolean[] visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            conn[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            conn[x].add(y);
            conn[y].add(x);
        }
        for (int i = 1; i <= n; i++) {
            Collections.sort(conn[i]);
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        int[] sequence = new int[n + 1];
        int count = 1;
        while (!stack.isEmpty()) {
            int curr = stack.pop();
            if (visited[curr]) continue;
            visited[curr] = true;
            sequence[curr] = count++;
            for (int next : conn[curr]) {
                if (visited[next]) continue;
                stack.push(next);
            }
        }
        for (int i = 1; i <= n; i++) {
            bw.write(sequence[i] + "\n");
        }
        bw.flush();
    }
}
