package com.soi.baekjoon;

import java.io.*;

public class BOJ_1455 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] line = br.readLine().split(" ");
        int row = Integer.parseInt(line[0]);
        int col = Integer.parseInt(line[1]);
        boolean[][] map = new boolean[row][col];
        boolean[][] flipMap = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            String mapLine = br.readLine();
            for (int j = 0; j < col; j++) {
                map[i][j] = mapLine.charAt(j) - '0' == 1;
            }
        }
        br.close();
        int flipCount = 0;
        for (int r = row - 1; r >= 0; r--) {
            for (int c = col - 1; c >= 0; c--) {
                if (flipMap[r][c] != map[r][c]) {
                    flipCount++;
                    for (int rr = 0; rr <= r; rr++) {
                        for (int cc = 0; cc <= c; cc++) {
                            flipMap[rr][cc] = !flipMap[rr][cc];
                        }
                    }
                }
            }
        }
        bw.write(flipCount + "\n");
        bw.flush();
    }
}
