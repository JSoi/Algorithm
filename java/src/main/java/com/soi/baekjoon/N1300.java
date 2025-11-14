package com.soi.baekjoon;

import java.util.Scanner;

public class N1300 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();

        long start = 0;
        long end = K;
        long answer = 0;

        while (start <= end) {
            long mid = (start + end) / 2;
            long count = 0;
            for (int i = 1; i <= N; i++) {
                count += Math.min(mid / i, N);
            }
            if (count >= K) {
                answer = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(answer);
    }
}
