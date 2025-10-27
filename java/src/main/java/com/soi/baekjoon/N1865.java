package com.soi.baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class N1865 {
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < testCase; i++) {
            StringTokenizer tok = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(tok.nextToken());
            int m = Integer.parseInt(tok.nextToken());
            int w = Integer.parseInt(tok.nextToken());
            int[][] input = new int[m + w][3];
            for (int j = 0; j < m + w; j++) {
                StringTokenizer miniSt = new StringTokenizer(br.readLine());
                input[j][0] = Integer.parseInt(miniSt.nextToken()) - 1;
                input[j][1] = Integer.parseInt(miniSt.nextToken()) - 1;
                input[j][2] = Integer.parseInt(miniSt.nextToken());
            }
            TestCase tc = new TestCase(n, m, input);
            bw.append(tc.doesDiminish() ? "YES" : "NO").append("\n");
        }
        bw.flush();
    }

    private static class TestCase {
        int n;
        int[][] conn;
        List<int[]> edges = new ArrayList<>();

        public TestCase(int n, int roadCount, int[][] input) {
            this.n = n;
            conn = new int[n][n];
            for (int[] c : conn) {
                Arrays.fill(c, INF);
            }
            for (int i = 0; i < roadCount; i++) {
                int from = input[i][0];
                int to = input[i][1];
                int cost = input[i][2];
                edges.add(new int[]{from, to, cost});
                edges.add(new int[]{to, from, cost});
            }
            for (int i = roadCount; i < input.length; i++) {
                int from = input[i][0];
                int to = input[i][1];
                int cost = -input[i][2];
                edges.add(new int[]{from, to, cost});
            }
        }

        boolean doesDiminish() {
            int[] dist = new int[n];
            for (int i = 0; i < n - 1; i++) { // 간선 길이만큼 순회
                for (int[] e : edges) {
                    int from = e[0], to = e[1], cost = e[2];
                    if (dist[to] > dist[from] + cost) {
                        dist[to] = dist[from] + cost;
                    }
                }
            }
            for (int[] e : edges) {
                int from = e[0], to = e[1], cost = e[2];
                if (dist[to] > dist[from] + cost) {
                    return true;
                }
            }
            return false;
        }
    }
}
