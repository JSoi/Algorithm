package com.soi.baekjoon;

import java.io.IOException;
import java.util.Scanner;

public class BOJ_1010 {
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        int testcase = scan.nextInt();
        StringBuffer buf = new StringBuffer();
        for (int c = 0; c < testcase; c++) {
            int n = scan.nextInt();
            int m = scan.nextInt();
            buf.append(solve(n, m) + "\n");
        }
        scan.close();
        System.out.println(buf);
    }

    public static int solve(int n, int m) {
        int[][] myc = new int[n + 1][m + 1];
        for (int k = 0; k <= m; k++) {
            myc[1][k] = k;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= m; j++) {
                for (int l = j; l >= i; l--) {
                    myc[i][j] += myc[i - 1][l - 1];
                }
            }
        }
        return myc[n][m];
    }

}
