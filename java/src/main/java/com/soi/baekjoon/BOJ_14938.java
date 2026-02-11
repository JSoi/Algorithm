package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14938 {
    private static final int INF = Integer.MAX_VALUE;
    private static int[] itemCount;
    private static int N, M;
    // 플로이드 워셜
    private static int[][] conn;

    public static void main(String[] args) throws IOException {
        init();
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (i == j || conn[i][k] == INF || conn[k][j] == INF) {
                        continue;
                    }
                    conn[i][j] = Math.min(conn[i][j], conn[i][k] + conn[k][j]);
                }
            }
        }
        int maxItemCount = 0;
//        System.out.println(Arrays.deepToString(conn));
        for (int i = 0; i < N; i++) {
            int sum = itemCount[i];
            for (int j = 0; j < N; j++) {
                if (conn[i][j] <= M && conn[i][j] > 0) {
                    sum += itemCount[j];
                }
            }
            maxItemCount = Math.max(maxItemCount, sum);
        }
        System.out.println(maxItemCount);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        itemCount = new int[N];
        conn = new int[N][N];
        for (int[] c : conn) {
            Arrays.fill(c, INF);
        }

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            itemCount[i] = Integer.parseInt(st.nextToken());
        }

        int R = Integer.parseInt(input[2]);

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int l = Integer.parseInt(st.nextToken());
            conn[a][b] = conn[b][a] = l;
        }
//        System.out.println(Arrays.deepToString(conn));
    }
}
