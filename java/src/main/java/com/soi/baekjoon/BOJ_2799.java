package com.soi.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2799 {
    private static char[][] building;
    private static int r, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
        int m = Integer.parseInt(tok.nextToken());
        int n = Integer.parseInt(tok.nextToken());
        r = 5 * m + 1;
        c = 5 * n + 1;
        building = new char[r][c];
        for (int i = 0; i < r; i++) {
            building[i] = br.readLine().toCharArray();
        }
        // 1 , 6, 11, 16, 21
        int[] answer = new int[5];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int startR = 5 * i + 1;
                int startC = 5 * j + 1;
                int pattern = getPattern(startR, startC);
                if (pattern == -1)
                    continue;
                answer[pattern]++;
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 5; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb);

    }

    private static int getPattern(int startR, int startC) {
        int blindCount = 0;
        int openCount = 0;
        boolean blindEnd = false;
        for (int r = startR; r < startR + 4; r++) {
            for (int c = startC; c < startC + 4; c++) {
                if (building[r][c] == '.') {
                    blindEnd = true;
                    openCount++;
                } else {
                    if (blindEnd) return -1;
                    blindCount++;
                }
            }
            if (blindCount % 4 != 0 || openCount % 4 != 0) {
                return -1;
            }
        }
        return blindCount / 4;
    }
}
