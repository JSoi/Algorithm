package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_17135 {
    private static final int[][] pos = new int[][]{{0, -1}, {-1, 0}, {0, 1}};
    private static int r, c, d;
    private static List<int[]> archerPositions;
    private static Set<Position> eliminated;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        int[][] original = new int[r][c];
        map = new int[r][c];
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                original[i][j] = map[i][j];
            }
        }


        archerPositions = new ArrayList<>();
        permutation(0, 0, new int[3]);

        int answer = 0;
        for (int[] archerPos : archerPositions) {
            eliminated = new HashSet<>();
            copy(original);
            for (int archorRow = r; archorRow >= 1; archorRow--) {
                for (int archorNo = 0; archorNo < 3; archorNo++) {
                    shoot(archorRow, archerPos[archorNo]);
                }
                for (Position ee : eliminated) {
                    map[ee.r][ee.c] = 0;
                }
            }
            answer = Math.max(answer, eliminated.size());
        }
        System.out.println(answer);
    }

    private static void permutation(int curr, int idx, int[] position) {
        if (idx >= 3) {
            archerPositions.add(new int[]{position[0], position[1], position[2]});
            return;
        }
        for (int i = curr; i < c; i++) {
            position[idx] = i;
            permutation(i + 1, idx + 1, position); // choose
        }
    }

    private static void shoot(int archerR, int archerC) {
        boolean[][] v = new boolean[r][c];
        Queue<Position> bfs = new LinkedList<>();
        bfs.add(new Position(archerR - 1, archerC));
        v[archerR - 1][archerC] = true;
        while (!bfs.isEmpty()) {
            Position curr = bfs.poll();
            if (map[curr.r][curr.c] == 1) {
                eliminated.add(curr);
                return;
            }
            for (int[] p : pos) {
                int r = p[0] + curr.r;
                int c = p[1] + curr.c;
                if (!inRange(r, c) || v[r][c] || Math.abs(r - archerR) + Math.abs(c - archerC) > d) {
                    continue;
                }
                v[r][c] = true;
                bfs.offer(new Position(r, c));
            }
        }
    }

    private static void copy(int[][] original) {
        for (int i = 0; i < r; i++) {
            System.arraycopy(original[i], 0, map[i], 0, c);
        }
    }

    private static boolean inRange(int rr, int cc) {
        return rr >= 0 && rr < r && cc >= 0 && cc < c;
    }

    private record Position(int r, int c) {

    }
}
