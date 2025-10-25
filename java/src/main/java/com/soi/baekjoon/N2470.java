package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Long.parseLong(st.nextToken());
        Arrays.sort(arr);

        int l = 0;
        int r = n - 1;
        long min = Long.MAX_VALUE;
        long leftValue = 0, rightValue = 0;

        while (l < r) {
            long sum = arr[l] + arr[r];
            long abs = Math.abs(sum);
            if (abs < min) {
                min = abs;
                leftValue = arr[l];
                rightValue = arr[r];
            }
            if (sum < 0) {
                l++;
            } else {
                r--;
            }
        }
        System.out.println(leftValue + " " + rightValue);
    }
}
