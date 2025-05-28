package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N1051 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int[] rectArr = new int[10];
        Arrays.fill(rectArr, 1);
        int[][] map = new int[row][col];
        for (int r = 0; r < row; r++) {
            char[] lineChar = br.readLine().toCharArray();
            for (int c = 0; c < col; c++) {
                map[r][c] = lineChar[c] - '0';
            }

        }
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                int offset = Math.min(row - r, col - c);
                for (int o = rectArr[map[r][c]]; o < offset; o++) {
                    if (isGoodRectangle(o, r, c, map)) {
                        rectArr[map[r][c]] = o + 1;
                    }
                }
            }
        }
        int maxLen = Arrays.stream(rectArr).max().orElse(0);
        System.out.println(maxLen*maxLen);
    }

    private static boolean isGoodRectangle(int offset, int startR, int startC, int[][] map) {
        int nextC = startC + offset;
        int nextR = startR + offset;
        if (nextR >= map.length || nextC >= map[0].length) {
            return false;
        }
        int standard = map[startR][startC];
        return standard == map[nextR][nextC]
                && standard == map[nextR][startC]
                && standard == map[startR][nextC];
    }
}
