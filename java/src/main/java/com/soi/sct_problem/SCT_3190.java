package com.soi.sct_problem;

import java.util.Scanner;

public class SCT_3190 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int K = scan.nextInt();
        int[][] Map = new int[N][N];
        int[][] ApplePosition = new int[K][2];
        for (int i = 0; i < 2 * N; i++) {
            for (int j = 0; j < 2; j++) {
                ApplePosition[i][j] = scan.nextInt();
            }
        }
        int L = scan.nextInt();
        int[] go = new int[L];
        String[] goD = new String[L];
        for (int c = 0; c < L; c++) {
            go[c] = scan.nextInt();
            goD[c] = scan.next();
        }
    }

}
