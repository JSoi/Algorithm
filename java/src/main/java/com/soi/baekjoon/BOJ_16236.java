package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_16236 {
    static final int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] startPos = new int[2];
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                int val = Integer.parseInt(tok.nextToken());
                map[i][j] = val;
                if (val == 9) {
                    startPos[0] = i;
                    startPos[1] = j;
                }
            }
        }
        map[startPos[0]][startPos[1]] = 0;
        int curRow = startPos[0];
        int curCol = startPos[1];
        int curSize = 2;
        int eatCount = 0;
        int answer = 0;

        while (true) {
            int[] target = suitableFishPos(curRow, curCol, curSize);
//            System.out.println(Arrays.toString(target));
            if (target == null) break;
            curRow = target[0];
            curCol = target[1];
            answer += target[2];
            map[curRow][curCol] = 0;
            eatCount++;
            if (eatCount == curSize) {
                curSize++;
                eatCount = 0;
            }
        }
        System.out.println(answer);
    }

    static int[] suitableFishPos(int r, int c, int curSize) {
        Queue<int[]> posQueue = new LinkedList<>();
        List<int[]> candidateFish = new ArrayList<>();
        boolean[][] visited = new boolean[map.length][map[0].length];

        posQueue.offer(new int[]{r, c, 0});
        visited[r][c] = true;

        while (!posQueue.isEmpty()) {
            int[] cur = posQueue.poll();
//            System.out.println(Arrays.toString(cur));
            int cR = cur[0];
            int cC = cur[1];
            int cD = cur[2];
            for (int[] d : dir) {
                int nR = cR + d[0];
                int nC = cC + d[1];
                if (nR < 0 || nR >= map.length || nC < 0 || nC >= map[0].length || visited[nR][nC] ||
                        map[nR][nC] > curSize) {
                    continue;
                }
                if (map[nR][nC] > 0 && map[nR][nC] < curSize) {
                    candidateFish.add(new int[]{nR, nC, cD + 1});
                }
                visited[nR][nC] = true;
                posQueue.offer(new int[]{nR, nC, cD + 1});
            }
        }
        // distance -> r asc -> c asc
        return candidateFish.stream().min((a, b) -> a[2] != b[2] ? a[2] - b[2] : a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]).orElse(null);
    }
}
