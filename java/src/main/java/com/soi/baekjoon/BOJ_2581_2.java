package com.soi.baekjoon;

import java.util.Scanner;

public class BOJ_2581_2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // M<N
        int M = scan.nextInt();
        int N = scan.nextInt();
        scan.close();
        int min = -1;
        int hap = 0;
        for (int k = N; k >= M; k--) {
            if (isPrime(k)) {
                hap += k;
                min = k;
            }
        }
        if (min == -1) {
            System.out.println(-1);
        } else {
            System.out.println(hap);
            System.out.println(min);
        }
    }

    static boolean isPrime(int input) {
        if (input < 2)
            return false;
        else {
            for (int i = 2; i < input; i++) {
                if (input % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    static void trash() {

        Scanner scan = new Scanner(System.in);
        // M<N
        int M = scan.nextInt();
        int N = scan.nextInt();
        scan.close();
        boolean[] array = new boolean[N + 1];
        array[2] = true;
        for (int i = 3; i <= N; i++) {
            int j;
            for (j = 2; j < i; j++) {
                if (i % j == 0) {
                    array[i] = false;
                    break;
                }
            }
            if (i == j) {
                array[i] = true;
            }
        }
        int min = -1;
        int hap = 0;
        for (int k = N; k >= M; k--) {
            if (array[k]) {
                hap += k;
                min = k;
            }
        }
        if (min == -1) {
            System.out.println(-1);
        } else {
            System.out.println(hap);
            System.out.println(min);
        }
    }

}
