package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N13398 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer tok = new StringTokenizer(br.readLine(), " ");

        long[] arr = new long[n + 1];
        long answer = Long.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(tok.nextToken());
            answer = Math.max(answer, arr[i]);
        }

        for (int i = 1; i <= n; i++) {
            long min = arr[i];
            long sum = arr[i];
            for (int j = i + 1; j <= n; j++) {
                min = Math.min(min, arr[j]);
                sum += arr[j];
                answer = Math.max(answer, Math.max(sum, sum - min));
            }
        }
        System.out.println(answer);
    }
}
