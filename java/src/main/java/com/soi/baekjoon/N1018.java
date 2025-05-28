package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1018 {
    static boolean[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int row = Integer.parseInt(input[0]);
        int col = Integer.parseInt(input[1]);
        map = new boolean[row][col];
        for (int r = 0; r < row; r++) {
            String line = br.readLine();
            for (int c = 0; c < col; c++) {
                map[r][c] = line.charAt(c) == 'B';
            }
        }
        int answer = Integer.MAX_VALUE;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                answer = Math.min(getCount(r, c), answer);
            }
        }
        System.out.println(answer);

    }

    private static int getCount(int row, int col) {
        if (row + 8 > map.length || col + 8 > map[0].length) return Integer.MAX_VALUE;
        int wCount = 0;
        int bCount = 0;
        boolean start = true;// black
        wCount = getSubCount(row, col, start, wCount);
        start = false;
        bCount = getSubCount(row, col, start, bCount);
        return Math.min(wCount, bCount);
    }

    private static int getSubCount(int row, int col, boolean start, int count) {
        for (int r = row; r < row + 8; r++) {
            start = !start;
            boolean colColor = start;
            for (int c = col; c < col + 8; c++) {
                if (map[r][c] != colColor) {
                    count++;
                }
                colColor = !colColor;
            }
        }
        return count;
    }
}
