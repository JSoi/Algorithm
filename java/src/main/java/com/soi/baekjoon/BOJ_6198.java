package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_6198 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        long answer = 0;
        for (int i = n - 1; i >= 0; i--) {
            long observable = 0;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] >= arr[i]) {
                    break;
                }
                observable++;
            }
            answer += observable;
        }
        System.out.println(answer);
    }
}
