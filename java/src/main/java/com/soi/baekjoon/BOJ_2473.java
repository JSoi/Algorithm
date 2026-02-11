package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2473 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];
        StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(tok.nextToken());
        }
        Arrays.sort(arr);

        long minAbs = Long.MAX_VALUE;
        long[] result = new long[3];
        for (int i = 0; i < n - 2; i++) {
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                long sum = arr[i] + arr[j] + arr[k];
                long absSum = Math.abs(sum);
                if (absSum < minAbs) {
                    minAbs = absSum;
                    result[0] = arr[i];
                    result[1] = arr[j];
                    result[2] = arr[k];
                    if (sum == 0) {
                        System.out.println(result[0] + " " + result[1] + " " + result[2]);
                    }
                }
                if (sum > 0) k--;
                else j++;
            }
        }
        System.out.println(result[0] + " " + result[1] + " " + result[2]);
    }
}
