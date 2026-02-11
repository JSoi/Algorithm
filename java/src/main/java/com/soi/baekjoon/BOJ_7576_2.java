package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_7576_2 {
    private static final int[][] movement = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private static int rowCount;
    private static int colCount;
    private static int[][] tomatoes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] countLine = br.readLine().split(" ");
        rowCount = Integer.parseInt(countLine[1]);
        colCount = Integer.parseInt(countLine[0]);
        tomatoes = new int[rowCount][colCount];
        for (int r = 0; r < rowCount; r++) {
            tomatoes[r] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        }

        Queue<Position> queue = new LinkedList<>();
        for (int r = 0; r < rowCount; r++) {
            for (int c = 0; c < colCount; c++) {
                if (tomatoes[r][c] == 1) {
                    queue.offer(new Position(r, c, 0));
                }
            }
        }
        // all tomatoes ripe
        if (queue.size() == rowCount * colCount) {
            System.out.println(0);
            return;
        }
        int day = 0;
        while (!queue.isEmpty()) {
            Position latest = queue.poll();
            day = latest.day;
            tomatoes[latest.r][latest.c] = 1;
            for (int[] m : movement) {
                int nextR = latest.r + m[0];
                int nextC = latest.c + m[1];
                if (nextR < 0 || nextR >= rowCount || nextC < 0 || nextC >= colCount ||
                        tomatoes[nextR][nextC] != 0) {
                    continue;
                }
                tomatoes[nextR][nextC] = 1;
                queue.offer(new Position(nextR, nextC, latest.day + 1));
            }
        }
        if (ripeTomatoCount() == -1) {
            System.out.println(-1);
        } else {
            System.out.println(day);
        }
    }

    private static int ripeTomatoCount() {
        int count = 0;
        for (int r = 0; r < rowCount; r++) {
            for (int c = 0; c < colCount; c++) {
                if (tomatoes[r][c] == 0) {
                    return -1;
                } else if (tomatoes[r][c] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    private static class Position {
        int r;
        int c;
        int day;

        public Position(int r, int c, int day) {
            this.r = r;
            this.c = c;
            this.day = day;
        }
    }
}
