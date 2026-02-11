package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class BOJ_7569 {
    static final int[][] movements = new int[][]{{0, 0, 1}, {0, 0, -1}, {1, 0, 0}, {0, 1, 0}, {-1, 0, 0}, {0, -1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] countArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int col = countArr[0], row = countArr[1], height = countArr[2];
        int[][][] tomatoes = new int[row][col][height];
        int intialHoleCount = 0;
        LinkedList<TomatoPos> queue = new LinkedList<>();
        for (int h = 0; h < height; h++) {
            for (int r = 0; r < row; r++) {
                int[] oneFloor = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
                for (int c = 0; c < col; c++) {
                    if (oneFloor[c] == 1) {
                        queue.offer(new TomatoPos(r, c, h, 0));
                    } else if (oneFloor[c] == -1) {
                        intialHoleCount++;
                    }
                    tomatoes[r][c][h] = oneFloor[c];
                }
            }
        }
        int day = 0;
        while (!queue.isEmpty()) {
            TomatoPos latest = queue.poll();
            day = latest.day;
            for (int[] m : movements) {
                int nR = latest.r + m[0];
                int nC = latest.c + m[1];
                int nH = latest.h + m[2];
                if (!isInRange(nR, nC, nH, row, col, height) || tomatoes[nR][nC][nH] != 0) {
                    continue;
                }
                tomatoes[nR][nC][nH] = 1;
                queue.offer(new TomatoPos(nR, nC, nH, latest.day + 1));
            }
        }

        int ripeCount = 0;
        for (int h = 0; h < height; h++) {
            for (int r = 0; r < row; r++) {
                for (int c = 0; c < col; c++) {
                    if (tomatoes[r][c][h] == 1) {
                        ripeCount++;
                    }
                }
            }
        }
        System.out.println(ripeCount == col * row * height - intialHoleCount ? day : -1);
    }

    private static boolean isInRange(int r, int c, int h, int rCount, int cCount, int hCount) {
        return r >= 0 && c >= 0 && h >= 0 && r < rCount && c < cCount && h < hCount;
    }

    private static class TomatoPos {
        int r;
        int c;
        int h;
        int day;

        public TomatoPos(int r, int c, int h, int day) {
            this.r = r;
            this.c = c;
            this.h = h;
            this.day = day;
        }
    }
}
