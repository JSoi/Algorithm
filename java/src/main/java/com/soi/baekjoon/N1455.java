package com.soi.baekjoon;

import java.io.*;

public class N1455 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] line = br.readLine().split(" ");
        int row = Integer.parseInt(line[1]);
        int col = Integer.parseInt(line[0]);
        int[][] map = new int[row][col];
        int[][] flipMap = new int[row][col];
        for (int i = 0; i < row; i++) {
            String mapLine = br.readLine();
            for (int j = 0; j < col; j++) {
                map[i][j] = mapLine.charAt(j) - '0';
            }
        }
        br.close();
        int flipCount = 0;
        for (int r = row - 1; r >= 0; r--) {
            for (int c = col - 1; c >= 0; c--) {
                if (map[r][c] != (flipMap[r][c] % 2 == 0 ? 0 : 1)) {
                    flipCount++;
                    for (int rr = 0; rr <= r; rr++) {
                        for (int cc = 0; cc <= c; cc++) {
                            flipMap[rr][cc]++;
                        }
                    }
                }
            }
        }
        bw.write(flipCount + "\n");
        bw.flush();
    }
}
