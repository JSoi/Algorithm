package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N18352 {
    public static final int MAX = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken()) - 1;
        int[][] conn = new int[N][N];
        for (int[] c : conn) {
            Arrays.fill(c, MAX);
        }
        for (int i = 0; i < N; i++) {
            conn[i][i] = 0;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            conn[a][b] = 1;
        }
        for (int k = 0; k < K; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if ( conn[i][k] == MAX || conn[k][j] == MAX) {
                        continue;
                    }
                    conn[i][j] = Math.min(conn[i][j], conn[i][k] + conn[k][j]);
                }
            }
        }
//        for (int[] c : conn) {
//            System.out.println(Arrays.toString(c));
//        }
        StringBuilder answerSb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (conn[X][i] == K) {
                answerSb.append(i+1).append("\n");
            }
        }
        System.out.println(answerSb.isEmpty() ? "-1" : answerSb.toString());
    }
}
