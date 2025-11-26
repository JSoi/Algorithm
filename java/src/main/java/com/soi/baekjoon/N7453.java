package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
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
        Map<Long, Integer> sumMap = new HashMap<>(2 * N);
        for (int k = 0; k < N; k++) {
            for (int l = 0; l < N; l++) {
                long sum = C[k] + D[l];
                sumMap.put(sum, sumMap.getOrDefault(sum, 0) + 1);
            }
        }

        long answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                long sum = A[i] + B[j];
                answer += sumMap.getOrDefault(-sum, 0);
            }
        }
        System.out.println(answer);
    }
}