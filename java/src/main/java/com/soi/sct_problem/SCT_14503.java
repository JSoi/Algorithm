package com.soi.sct_problem;

import java.util.Scanner;

public class SCT_14503 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();
        int x = scan.nextInt();
        int y = scan.nextInt();
        int dir = scan.nextInt();
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int[][] Map = new int[N][M];
        for (int k = 0; k < N; k++) {
            for (int l = 0; l < M; l++) {
                Map[k][l] = scan.nextInt();
            }
        }
        scan.close();
        while (true) {
            if (Map[x][y] == 0) {
                Map[x][y] = -1;
            }
            if (Map[x + 1][y] != 0 && Map[x][y + 1] != 0 && Map[x - 1][y] != 0 && Map[x][y - 1] != 0) {
                if (Map[x - dx[dir]][y - dy[dir]] == 1) {
                    break;
                } else {
                    x -= dx[dir];
                    y -= dy[dir];
                }
            } else {
                dir = (dir + 3) % 4;
                if (Map[x + dx[dir]][y + dy[dir]] == 0) {
                    x += dx[dir];
                    y += dy[dir];
                }
            }
        }
        int count = 0;
        for (int rn = 0; rn < N; rn++) {
            for (int rm = 0; rm < M; rm++) {
                if (Map[rn][rm] == -1) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

}
