package com.soi.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_10159 {
    // 18:00 - 18:17
    private static boolean[][] reachable;
    private static int n;

    public static void main(String[] args) throws IOException {
        init();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // bfs
        floydWarshall();
        for (int i = 0; i < n; i++) {
            int count = n;
            for (int j = 0; j < n; j++) {
                if (i == j || reachable[i][j] || reachable[j][i]) {
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
        reachable = new boolean[n][n];

        for (int i = 0; i < m; i++) {
            // a > b
            StringTokenizer tok = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(tok.nextToken()) - 1;
            int b = Integer.parseInt(tok.nextToken()) - 1;
            reachable[a][b] = true;
        }
    }

    private static void floydWarshall() {
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (reachable[i][k] && reachable[k][j]) {
                        reachable[i][j] = true;
                    }
                }
            }
        }
    }
}
