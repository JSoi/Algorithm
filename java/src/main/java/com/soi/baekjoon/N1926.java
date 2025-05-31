package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N1926 {
    static boolean[][] map;
    static int r, c;
    static final int[][] movements = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] rc = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        r = rc[0];
        c = rc[1];
        map = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < c; j++) {
                map[i][j] = line[j] == 1;
            }
        }
        int answer = 0;
        int count = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j]) {
                    count++;
                    int t = travel(i, j);
                    answer = Math.max(answer, t);
                }
            }
        }
        System.out.println(count);
        System.out.println(answer);
    }

    private static int travel(int i, int j) {
        int next = 0;
        map[i][j] = false;
        for (int[] m : movements) {
            int nR = i + m[0];
            int nC = j + m[1];
            if (nR < 0 || nR >= r || nC < 0 || nC >= c || !map[nR][nC]) {
                continue;
            }
            next += travel(nR, nC);
        }
        return 1 + next;
    }
}
