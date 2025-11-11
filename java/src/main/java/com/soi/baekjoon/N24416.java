package com.soi.baekjoon;

import java.util.Scanner;

public class N24416 {
    private static int recursiveCount = 0;
    private static int dpCount = 0;
    private static int[] dpArr;

    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        recursive(n);
        dp(n);
        System.out.print(recursiveCount + " " + dpCount);
    }

    private static int recursive(int n) {
        if (n == 1 || n == 2) {
            recursiveCount++;
            return 1;
        }
        return recursive(n - 1) + recursive(n - 2);
    }

    private static int dp(int n) {
        dpArr = new int[Math.max(3, n + 1)];
        dpArr[1] = dpArr[2] = 1;
        for (int i = 3; i <= n; i++) {
            dpCount++;
            dpArr[i] = dpArr[i - 2] + dpArr[i - 1];
        }
        return dpArr[n];
    }
}
