package com.soi.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class L994 {
    int[] ds = {0, 0, 1, -1};
    int[] dg = {1, -1, 0, 0};
    int garo, sero;

    public int orangesRotting(int[][] grid) {
        int sero = grid.length;
        int garo = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < sero; i++) {
            for (int j = 0; j < garo; j++) {
                // rotten = 2, empty = 0, fresh = 1
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j, 0});
                }
            }
        }
        int answer = 0;
        while (!queue.isEmpty()) {
            for (int count = 0; count < queue.size(); count++) {
                int[] now = queue.poll();
                answer = now[2];
                for (int i = 0; i < 4; i++) {
                    int s = now[0] + ds[i];
                    int g = now[1] + dg[i];
                    if (s < 0 || g < 0 || s >= sero || g >= garo || grid[s][g] != 1) {
                        continue;
                    }
                    grid[s][g] = 2;
                    queue.offer(new int[]{s, g, now[2] + 1});
                }
            }
        }
        for (int i = 0; i < sero; i++) {
            for (int j = 0; j < garo; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return answer;
    }
}
