package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2166 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] vertex = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            vertex[i][0] = Integer.parseInt(st.nextToken());
            vertex[i][1] = Integer.parseInt(st.nextToken());
        }
        double answer = 0;
        for (int i = 0; i < n; i++) {
            int j = (i + 1) % n;
            answer += vertex[i][0] * vertex[j][1];
            answer -= vertex[i][1] * vertex[j][0];
        }
        answer = Math.abs(answer) / 2;
        System.out.printf("%.1f", answer);
    }
}
