package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1976 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        boolean[][] conn = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                conn[i][j] = st.nextToken().equals("1");
            }
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    conn[i][j] |= conn[i][k] && conn[k][j];
                }
            }
        }
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int startIdx = Integer.parseInt(st.nextToken()) - 1;
        for (int i = 0; i < m - 1; i++) {
            int nextIdx = Integer.parseInt(st.nextToken()) - 1;
            if (startIdx != nextIdx && !conn[startIdx][nextIdx]) {
                System.out.println("NO");
                return;
            }
            startIdx = nextIdx;
        }
        System.out.println("YES");
    }
}
