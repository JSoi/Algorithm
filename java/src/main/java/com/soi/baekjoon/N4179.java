package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N4179 {
    private static boolean[][] isWall;
    private static int[][] fireTime;
    private static int r, c;
    private static final int IMP = Integer.MAX_VALUE;
    private static final int[][] movement = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        isWall = new boolean[r][c];
        fireTime = new int[r][c];
        for (int[] f : fireTime) {
            Arrays.fill(f, IMP);
        }
        int startR = 0, startC = 0;
        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                if (line.charAt(j) == '#') {
                    isWall[i][j] = true;
                } else if (line.charAt(j) == 'J') {
                    startR = i;
                    startC = j;
                } else if (line.charAt(j) == 'F') {
                    fireTime[i][j] = 0;
                }
            }
        }
        calculateFireTime();
        int answer = shortestEscapeTime(startR, startC);
        System.out.println(answer == IMP ? "IMPOSSIBLE" : answer);
    }

    private static void calculateFireTime() {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] v = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (fireTime[i][j] == 0) {
                    queue.offer(new int[]{i, j, 0});
                    v[i][j] = true;
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            fireTime[curr[0]][curr[1]] = Math.min(fireTime[curr[0]][curr[1]], curr[2]);
            for (int[] m : movement) {
                int nR = curr[0] + m[0];
                int nC = curr[1] + m[1];
                if (!inRange(nR, nC) || v[nR][nC] || isWall[nR][nC]) {
                    continue;
                }
                v[nR][nC] = true;
                queue.offer(new int[]{nR, nC, curr[2] + 1});
            }
        }
//        for (int[] f : fireTime) {
//            System.out.println(Arrays.toString(f));
//        }
    }

    private static boolean inRange(int rr, int cc) {
        return rr >= 0 && rr < r && cc >= 0 && cc < c;
    }

    private static int shortestEscapeTime(int rr, int cc) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] v = new boolean[r][c];
        queue.offer(new int[]{rr, cc, 0});
        v[rr][cc] = true;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            if (isEscaped(curr[0], curr[1])) {
                return curr[2] + 1;
            }
            for (int[] m : movement) {
                int nR = curr[0] + m[0];
                int nC = curr[1] + m[1];
                if (!inRange(nR, nC) || v[nR][nC] || isWall[nR][nC] || fireTime[nR][nC] <= curr[2]+1) {
                    continue;
                }
                v[nR][nC] = true;
                queue.offer(new int[]{nR, nC, curr[2] + 1});
            }
        }
        return IMP;
    }

    private static boolean isEscaped(int rr, int cc) {
        return (rr == 0 || rr == r - 1 || cc == 0 || cc == c - 1) && !isWall[rr][cc];
    }
}
