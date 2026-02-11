package com.soi.baekjoon;

import java.io.*;
import java.util.Arrays;

public class BOJ_1240 {
    static final int max = 1000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int[][] cost = new int[N][N];
        for (int[] c : cost) {
            Arrays.fill(c, max);
        }
        for (int i = 0; i < N - 1; i++) {
            input = br.readLine().split(" ");
            int from = Integer.parseInt(input[0]) - 1;
            int to = Integer.parseInt(input[1]) - 1;
            int dist = Integer.parseInt(input[2]);
            cost[from][to] = cost[to][from] = dist;
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    cost[i][j] = Math.min(cost[i][j], cost[i][k] + cost[k][j]);
                }
            }
        }
        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int from = Integer.parseInt(input[0]) - 1;
            int to = Integer.parseInt(input[1]) - 1;
            bw.append(String.valueOf(cost[from][to])).append("\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
