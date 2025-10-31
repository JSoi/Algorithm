package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1992 {
    private static boolean[][] map;
    private static int n;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        init();
        divide(0, 0, n);
        System.out.println(sb);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        map = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j) == '1';
            }
        }
//        System.out.println(Arrays.deepToString(map));
    }

    private static void divide(int r, int c, int size) {
        if (size == 1) {
            sb.append(map[r][c] ? "1" : "0");
            return;
        }
        if(isIdentical(r, c, size)){
            sb.append(map[r][c] ? "1" : "0");
            return;
        }
        int nextSize = size / 2;
        sb.append("(");
        for (int i = 0; i < 4; i++) {
            divide(r + nextSize * (i / 2), c + nextSize * (i % 2), nextSize);
        }
        sb.append(")");
    }

    private static boolean isIdentical(int r, int c, int size) {
        boolean color = map[r][c];
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (color != map[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
