package com.soi.baekjoon;

import java.io.*;
import java.util.Arrays;

public class BOJ_1007 {
    static int N;
    static double minLength;
    static boolean[] selected;
    static int[][] points;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());
        for (int t = 0; t < testCase; t++) {
            N = Integer.parseInt(br.readLine());
            points = new int[N][2];
            for (int j = 0; j < N; j++) {
                points[j] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
            minLength = Double.MAX_VALUE;
            selected = new boolean[N];
            dfs(0, 0);
            bw.append(String.valueOf(minLength)).append("\n");
        }
        bw.flush();
    }

    private static void dfs(int index, int count) {
        if (count == N / 2) {
            long sumX = 0, sumY = 0;
            for (int i = 0; i < N; i++) {
                if (selected[i]) {
                    sumX += points[i][0];
                    sumY += points[i][1];
                } else {
                    sumX -= points[i][0];
                    sumY -= points[i][1];
                }
            }
            double length = Math.sqrt(sumX * sumX + sumY * sumY);
            minLength = Math.min(minLength, length);
            return;
        }
        if (index == N) return;
        selected[index] = true;
        dfs(index + 1, count + 1);
        selected[index] = false;
        dfs(index + 1, count);
    }
}
