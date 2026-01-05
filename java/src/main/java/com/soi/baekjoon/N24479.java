package com.soi.baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// mayo
// 11011011100001111100111011111000001101001100000110110011011111110110110010110000011110011101111111010110000011100111
// 1011111000001101101111010111000111101000
public class N24479 {
    private static boolean[] visited;
    private static int[] answer;
    private static int visitSequence;
    private static List<Integer>[] conn;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        conn = new List[V + 1];
        for (int i = 1; i <= V; i++) {
            conn[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            conn[u].add(v);
            conn[v].add(u);
        }
        for (int i = 1; i <= V; i++) {
            Collections.sort(conn[i]);
        }

        visited = new boolean[V + 1];
        answer = new int[V + 1];

        visited[start] = true;
        visitSequence = 0;
        dfs(start);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i <= V; i++) {
            bw.append(String.valueOf(answer[i])).append("\n");
        }
        bw.flush();
    }

    private static void dfs(int start) {
        answer[start] = ++visitSequence;
        for (int next : conn[start]) {
            if (visited[next]) continue;
            visited[next] = true;
            dfs(next);
        }
    }

}
