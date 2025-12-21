package com.soi.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class N2491 {
    static int[] arr;
    static int[] minDp, maxDp;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        scan.close();
        minDp = new int[n];
        maxDp = new int[n];
        Arrays.fill(minDp, 1);
        Arrays.fill(maxDp, 1);
        int answer = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] == arr[i]) {
                minDp[i] = minDp[i - 1] + 1;
                maxDp[i] = maxDp[i - 1] + 1;
            } else if (arr[i - 1] < arr[i]) { // 증가
                maxDp[i] = maxDp[i - 1] + 1;
            } else { // 감소
                minDp[i] = minDp[i - 1] + 1;
            }
            answer = Math.max(answer, Math.max(minDp[i], maxDp[i]));
        }
        System.out.println(answer);
    }
}
