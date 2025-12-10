package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N7453 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] A = new long[N];
        long[] B = new long[N];
        long[] C = new long[N];
        long[] D = new long[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
            A[i] = Long.parseLong(tok.nextToken());
            B[i] = Long.parseLong(tok.nextToken());
            C[i] = Long.parseLong(tok.nextToken());
            D[i] = Long.parseLong(tok.nextToken());
        }
        long[] AB = new long[N * N]; // AB 합 저장
        long[] CD = new long[N * N]; // CD 합 저장 (정렬필요)

        int idx = 0;
        for (long a : A) {
            for (long b : B) {
                AB[idx++] = a + b;
            }
        }

        idx = 0;
        for (long c : C) {
            for (long d : D) {
                CD[idx++] = c + d;
            }
        }
        Arrays.sort(CD);

        long answer = 0;
        for (long ab : AB) {
            int upperBound = upperBound(CD, -ab);
            int lowerBound = lowerBound(CD, -ab);
            answer += upperBound - lowerBound;
        }
        System.out.println(answer);
    }

    static int lowerBound(long[] arr, long target) {
        int l = 0;
        int r = arr.length;
        while (l < r) {
            int m = (l + r) / 2;
            if (arr[m] >= target) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    static int upperBound(long[] arr, long target) {
        int l = 0;
        int r = arr.length;
        while (l < r) {
            int m = (l + r) / 2;
            if (arr[m] > target) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}