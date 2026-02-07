package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N2847 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        if (n == 1) {
            System.out.println(0);
            return;
        }

        int answer = 0;
        int max = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= max) {
                answer += arr[i] - max + 1;
                arr[i] = max - 1;
            }
            max = arr[i];
        }
        System.out.println(answer);
    }
}
