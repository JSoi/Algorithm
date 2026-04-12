package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ_17136 {
    public static final int MAX = Integer.MAX_VALUE;
    private static boolean[][] map;
    private static final int[] leftPapers = new int[]{0, 5, 5, 5, 5, 5}; // 남은 색종이 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        map = new boolean[10][10];
        for (int i = 0; i < 10; i++) {
            StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 10; j++) {
                map[i][j] = tok.nextToken().equals("1");
            }
        }
        int answer = solve(0);
        System.out.println(answer == MAX ? -1 : answer);

    }

    private static int solve(int count) {
        if (allFilled()) return count;
        int minCount = MAX;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (!map[i][j]) continue;
                for (int size = 5; size > 0; size--) {
                    if (!canPlace(i, j, size) || leftPapers[size] == 0) continue;
                    place(i, j, size, false);
                    leftPapers[size]--;
                    minCount = Math.min(minCount, solve(count + 1));
                    place(i, j, size, true);
                    leftPapers[size]++;
                }
                return minCount;
            }
        }
        return minCount;
    }

    private static void place(int i, int j, int size, boolean b) {
        for (int ii = i; ii < i + size; ii++) {
            for (int jj = j; jj < j + size; jj++) {
                map[ii][jj] = b;
            }
        }
    }

    private static boolean canPlace(int i, int j, int size) {
        if (i + size > 10 || j + size > 10) return false;
        for (int ii = i; ii < i + size; ii++) {
            for (int jj = j; jj < j + size; jj++) {
                if (!map[ii][jj]) {
                    return false;
                }
            }
        }
        return true;
    }


    private static boolean allFilled() {
        for (boolean[] row : map) {
            for (boolean cell : row) {
                if (cell) return false;
            }
        }
        return true;
    }
}
