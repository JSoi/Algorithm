package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N14503 {
    private static final int[][] DIR = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
        int row = Integer.parseInt(tok.nextToken());
        int col = Integer.parseInt(tok.nextToken());
        int[][]  map = new int[row][col];
        tok = new StringTokenizer(br.readLine(), " ");
        int r = Integer.parseInt(tok.nextToken());
        int c = Integer.parseInt(tok.nextToken());
        int d = Integer.parseInt(tok.nextToken());

        for (int i = 0; i < row; i++) {
            tok = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(tok.nextToken());
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c, d});
        // 벽 : 1, 청소X : 0 , 청소O : 2

        int cleaned = 0;
        while (true) {
            if (map[r][c] == 0) {
                map[r][c] = 2;
                cleaned++;
            }

            boolean found = false;
            for (int i = 0; i < 4; i++) {
                d = (d + 3) % 4;
                int nr = r + DIR[d][0];
                int nc = c + DIR[d][1];

                if (map[nr][nc] == 0) {
                    r = nr;
                    c = nc;
                    found = true;
                    break;
                }
            }

            if (found) continue;

            int back = (d + 2) % 4;
            int backR = r + DIR[back][0];
            int backC = c + DIR[back][1];

            if (map[backR][backC] == 1) {
                System.out.println(cleaned);
                return;
            }

            r = backR;
            c = backC;
        }
    }
}
