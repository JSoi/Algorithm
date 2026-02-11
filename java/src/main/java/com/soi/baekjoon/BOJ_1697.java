package com.soi.baekjoon;

import java.util.Scanner;

public class BOJ_1697 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int K = scan.nextInt();
        scan.close();

        int[] path = new int[1000001];
        for (int i = 0; i < path.length; i++) {
            path[i] = 1000001;
        }
        path[N] = 0;
        if (N < K) {
            for (int m = 0; m < N; m++) {
                path[m] = N - m;
            }
            for (int i = N + 1; i <= K; i++) {
                if (i % 2 == 0) {
                    path[i] = Math.min(Math.min(path[i - 1] + 1, path[i + 1] + 1), path[i / 2] + 1);
                } else {
                    path[i] = Math.min(path[i - 1] + 1, path[(i + 1) / 2] + 2);
                }
                path[i * 2] = path[i] + 1;
            }
            System.out.println(path[K]);
        } else {
            System.out.println(N - K);
        }
    }
}
