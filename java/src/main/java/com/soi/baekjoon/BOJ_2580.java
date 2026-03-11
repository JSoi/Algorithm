package com.soi.baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_2580 {
    private static final int[][] map = new int[9][9];
    private static final List<int[]> blanks = new ArrayList<>();
    private static final int[] rowMask = new int[9];
    private static final int[] colMask = new int[9];
    private static final int[] boxMask = new int[9];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int rr = 0; rr < 9; rr++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int cc = 0; cc < 9; cc++) {
                int num = Integer.parseInt(st.nextToken());
                map[rr][cc] = num;
                if (num == 0) {
                    blanks.add(new int[]{rr, cc});
                } else {
                    int bit = 1 << num;
                    rowMask[rr] |= bit;
                    colMask[cc] |= bit;
                    boxMask[boxIndex(rr, cc)] |= bit;
                }
            }
        }
        stoku(0);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(map[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    private static boolean stoku(int idx) {
        if (idx == blanks.size()) {
            return true;
        }
        int[] pos = blanks.get(idx);
        int r = pos[0];
        int c = pos[1];
        int b = boxIndex(r, c);

        int used = rowMask[r] | colMask[c] | boxMask[b];

        for (int num = 1; num <= 9; num++) {
            int numBit = 1 << num;
            if ((used & numBit) != 0) continue;
            map[r][c] = num;
            rowMask[r] |= numBit;
            colMask[c] |= numBit;
            boxMask[b] |= numBit;
            if (stoku(idx + 1)) return true;
            map[r][c] = 0;
            rowMask[r] &= ~numBit;
            colMask[c] &= ~numBit;
            boxMask[b] &= ~numBit;
        }
        return false;
    }

    private static int boxIndex(int r, int c) {
        return (r / 3) * 3 + (c / 3);
    }
}
