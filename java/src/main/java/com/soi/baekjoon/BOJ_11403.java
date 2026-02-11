package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11403 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] map = new boolean[n][n];
        for (int l = 0; l < n; l++) {
            StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
            for (int ll = 0; ll < n; ll++) {
                map[l][ll] = Integer.parseInt(tok.nextToken()) == 1;
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] |= (map[i][k] && map[k][j]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print((map[i][j] ? 1 : 0) + " ");
            }
            System.out.println();
        }
    }
}
