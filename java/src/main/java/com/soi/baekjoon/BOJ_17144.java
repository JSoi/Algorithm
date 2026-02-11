package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17144 {
    private static final int[][] move = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static int cUpper;
    private static int cLower;
    private static int r, c, t;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        input();
        while (t-- > 0) {
            spread();
            circulate();
        }
        System.out.println(Arrays.stream(map).map(row -> Arrays.stream(row).sum()).reduce(Integer::sum).orElse(0) + 2);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(tok.nextToken());
        c = Integer.parseInt(tok.nextToken());
        t = Integer.parseInt(tok.nextToken());
        map = new int[r][c];
        for (int i = 0; i < r; i++) {
            tok = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(tok.nextToken());
                if (map[i][j] == -1) {
                    if (cUpper == 0) {
                        cUpper = i;
                    } else {
                        cLower = i;
                    }
                }
            }
        }
    }

    private static void spread() {
        int[][] offset = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == -1 || map[i][j] == 0) {
                    continue;
                }
                int sCount = 0;
                int sAmount = map[i][j] / 5;
                for (int[] m : move) {
                    int nR = m[0] + i, nC = m[1] + j;
                    if (nR < 0 || nR >= r || nC < 0 || nC >= c || map[nR][nC] == -1) {
                        continue;
                    }
                    offset[nR][nC] += sAmount;
                    sCount++;
                }
                map[i][j] -= sAmount * sCount;
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                map[i][j] += offset[i][j];
            }
        }
    }

    private static void circulate() {
        // 위쪽 (반시계)
        for (int i = cUpper - 1; i > 0; i--) map[i][0] = map[i - 1][0]; // 아래로
        for (int i = 0; i < c - 1; i++) map[0][i] = map[0][i + 1];     // 왼쪽으로
        for (int i = 0; i < cUpper; i++) map[i][c - 1] = map[i + 1][c - 1]; // 위로
        for (int i = c - 1; i > 1; i--) map[cUpper][i] = map[cUpper][i - 1]; // 오른쪽으로
        map[cUpper][1] = 0;

        // 아래쪽 (시계)
        for (int i = cLower + 1; i < r - 1; i++) map[i][0] = map[i + 1][0]; // 위로
        for (int i = 0; i < c - 1; i++) map[r - 1][i] = map[r - 1][i + 1];  // 왼쪽으로
        for (int i = r - 1; i > cLower; i--) map[i][c - 1] = map[i - 1][c - 1]; // 아래로
        for (int i = c - 1; i > 1; i--) map[cLower][i] = map[cLower][i - 1]; // 오른쪽으로
        map[cLower][1] = 0;
    }


}
