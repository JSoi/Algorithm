package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N2631 {
    // LIS
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] children = new int[n];
        for (int i = 0; i < n; i++) {
            children[i] = Integer.parseInt(br.readLine());
        }
        int[] lis = new int[n];
        Arrays.fill(lis, 1);
        int maxLen = 0;
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (children[i] > children[j]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, lis[i]);
        }
        System.out.println(n - maxLen);
    }
}
