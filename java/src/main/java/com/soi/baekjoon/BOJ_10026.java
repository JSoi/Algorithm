package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10026 {
    static final int[][] movement = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        boolean[][][] visit = new boolean[len][len][2];
        char[][] map = new char[len][len];
        for (int r = 0; r < len; r++) {
            map[r] = br.readLine().toCharArray();
        }
        int normalCount = 0;
        int weakCount = 0;
        for (int r = 0; r < len; r++) {
            for (int c = 0; c < len; c++) {
                if (!visit[r][c][0]) { // normal
                    normalCount++;
                    go(r, c, false, map, visit);
                }
                if (!visit[r][c][1]) { // weak
                    weakCount++;
                    go(r, c, true, map, visit);
                }
            }
        }
        System.out.println(normalCount + " " + weakCount);
    }

    static void go(int r, int c, boolean isWeak, char[][] map, boolean[][][] visit) {
        for (int[] m : movement) {
            int nextR = r + m[0];
            int nextC = c + m[1];
            if (nextC < 0 || nextC >= map.length || nextR < 0 || nextR >= map.length ||
                    visit[nextR][nextC][isWeak ? 1 : 0] ||
                    !isSameSection(map[r][c], map[nextR][nextC], isWeak)) {
                continue;
            }
            visit[nextR][nextC][isWeak ? 1 : 0] = true;
            go(nextR, nextC, isWeak, map, visit);
        }
    }

    static boolean isSameSection(char now, char next, boolean isWeak) {
        if (!isWeak) {
            return now == next;
        }
        return now == next || (now != 'B' && next != 'B');
    }
}
