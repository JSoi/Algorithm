package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11660 {

    public static void main(String[] args) throws IOException {

        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tok = new StringTokenizer(buf.readLine());
        int n = Integer.parseInt(tok.nextToken());
        int m = Integer.parseInt(tok.nextToken());
        int[][] arr = new int[n + 1][n + 1];
        int[][] D = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            tok = new StringTokenizer(buf.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(tok.nextToken());
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                D[i][j] = D[i - 1][j] + D[i][j - 1] - D[i - 1][j - 1] + arr[i][j];
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < m; i++) {
            tok = new StringTokenizer(buf.readLine());
            int a = Integer.parseInt(tok.nextToken());
            int b = Integer.parseInt(tok.nextToken());
            int c = Integer.parseInt(tok.nextToken());
            int d = Integer.parseInt(tok.nextToken());
            int val = D[c][d] - D[a - 1][d] - D[c][b - 1] + D[a - 1][b - 1];
            sb.append(val + "\n");
        }
        System.out.println(sb);
    }

}
