package com.soi.baekjoon;

import java.io.*;
import java.util.Arrays;

public class BOJ_10211 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            int[] sumArr = Arrays.copyOf(arr, arr.length);
            for (int i = 1; i < n; i++) {
                sumArr[i] += sumArr[i - 1];
            }
            int max = sumArr[0];
            for (int i = 1; i < n; i++) {
                int maxValue = sumArr[i];
                for (int j = 0; j < i; j++) {
                    maxValue = Math.max(maxValue, sumArr[i] - sumArr[j]);
                }
                max = Math.max(max, maxValue);
            }
            bw.write(max + "\n");
        }
        bw.flush();
    }
}
