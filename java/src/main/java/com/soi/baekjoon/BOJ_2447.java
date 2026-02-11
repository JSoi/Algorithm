package com.soi.baekjoon;

import java.util.Scanner;

public class BOJ_2447 {
    static char[][] stars;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        stars = new char[n][n];
        draw(0, 0, n);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(stars[i][j] == '\0' ? " " : stars[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static void draw(int startR, int startC, int size) {
        if (size == 3) {
            for (int i = startR; i < startR + 3; i++) {
                for (int j = startC; j < startC + 3; j++) {
                    if (i == startR + 1 && j == startC + 1) {
                        continue;
                    }
                    stars[i][j] = '*';
                }
            }
            return;
        }
        int nextSize = size / 3;
        for (int i = 0; i < 9; i++) {
            if (i == 4) {
                continue;
            }
            int rOffset = i / 3;
            int cOffset = i % 3;
            draw(startR + rOffset * nextSize, startC + cOffset * nextSize, nextSize);
        }
    }
}
