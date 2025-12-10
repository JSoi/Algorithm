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
        int size = N * N;
        long[] AB = new long[size];
        long[] CD = new long[size];

        int idx = 0;
        for (long a : A)
            for (long b : B)
                AB[idx++] = a + b;

        idx = 0;
        for (long c : C)
            for (long d : D)
                CD[idx++] = c + d;

        Arrays.sort(AB);
        Arrays.sort(CD);

        long answer = findZeroSumCount(size, AB, CD);

        System.out.println(answer);
    }

    private static long findZeroSumCount(int size, long[] AB, long[] CD) {
        long answer = 0;
        int abIdx = 0;
        int cdIdx = size - 1;

        while (abIdx < size && cdIdx >= 0) {
            long sum = AB[abIdx] + CD[cdIdx];
            if (sum == 0) {
                long abVal = AB[abIdx];
                int abCount = 0;
                while (abIdx < size && AB[abIdx] == abVal) {
                    abCount++;
                    abIdx++;
                }
                long cdVal = CD[cdIdx];
                int cdCount = 0;
                while (cdIdx >= 0 && CD[cdIdx] == cdVal) {
                    cdCount++;
                    cdIdx--;
                }
                answer += (long) abCount * cdCount;
            } else if (sum < 0) {
                abIdx++;
            } else {
                cdIdx--;
            }
        }
        return answer;
    }
}