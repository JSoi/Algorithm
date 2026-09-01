package com.soi.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class LC_minimum_moves_to_clean_the_classroom {
    private char[][] map;
    private int r, c, targetLitter;
    final int[][] move = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public int minMoves(String[] classroom, int energy) {
        r = classroom.length;
        c = classroom[0].length();
        int startR = 0, startC = 0;
        map = new char[r][c];
        int litterCount = 0;
        int[][] litterIndex = new int[r][c];
        for (int i = 0; i < r; i++) {
            map[i] = new char[c];
            for (int j = 0; j < c; j++) {
                map[i][j] = classroom[i].charAt(j);
                if (map[i][j] == 'S') {
                    startR = i;
                    startC = j;
                } else if (map[i][j] == 'L') {
                    litterIndex[i][j] = litterCount++;
                }
            }
        }
        int fullMask = (1 << litterCount) - 1;
        int[][][] bestEnergy = new int[r][c][1 << litterCount];
        for (int[][] a : bestEnergy)
            for (int[] b : a)
                Arrays.fill(b, -1);

        int answer = Integer.MAX_VALUE;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{startR, startC, 0, energy, 0});
        bestEnergy[startR][startC][0] = energy;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cr = cur[0], cc = cur[1], mask = cur[2], en = cur[3], mv = cur[4];

            if (answer <= mv)
                continue;
            if (mask == fullMask) {
                answer = Math.min(answer, mv);
                continue;
            }
            if (en <= 0)
                continue;

            for (int[] m : move) {
                int nr = cr + m[0], nc = cc + m[1];
                if (!inRange(nr, nc) || map[nr][nc] == 'X')
                    continue;

                int nMask = mask;
                int nEnergy = en - 1;
                if (map[nr][nc] == 'L')
                    nMask |= (1 << litterIndex[nr][nc]);
                if (map[nr][nc] == 'R')
                    nEnergy = energy;

                if (nEnergy > bestEnergy[nr][nc][nMask]) {
                    bestEnergy[nr][nc][nMask] = nEnergy;
                    queue.offer(new int[]{nr, nc, nMask, nEnergy, mv + 1});
                }
            }
        }
        return answer == Integer.MAX_VALUE ? -1 : answer;

    }

    private boolean inRange(int rr, int cc) {
        return rr >= 0 & rr < r && cc >= 0 && cc < c;
    }
}
