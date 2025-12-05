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
        long[][] minArr = new long[n + 1][n + 1];
        long[][] sumArr = new long[n + 1][n + 1];
        minArr[1][0] = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            int value = Integer.parseInt(tok.nextToken());
            arr[i] = value;
        }
        long answer = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            minArr[i][i] = arr[i];
            sumArr[i][i] = arr[i];
            answer = Math.max(answer, arr[i]);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                minArr[i][j] = Math.min(minArr[i][j - 1], arr[j]);
                sumArr[i][j] = sumArr[i][j - 1] + arr[j];
                answer = Math.max(answer, Math.max(sumArr[i][j] - minArr[i][j], sumArr[i][j]));
            }
        }
        System.out.println(answer);
    }
}
