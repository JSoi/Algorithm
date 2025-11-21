package com.soi.baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N11728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(tok.nextToken());
        int M = Integer.parseInt(tok.nextToken());
        long[] first = new long[N];
        long[] second = new long[M];
        tok = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            first[i] = Long.parseLong(tok.nextToken());
        }
        tok = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            second[i] = Long.parseLong(tok.nextToken());
        }
        Arrays.sort(first);
        Arrays.sort(second);
        int fIdx = 0;
        int sIdx = 0;
        while (fIdx < N && sIdx < M) {
            if (first[fIdx] <= second[sIdx]) {
                bw.append(first[fIdx++] + " ");
            } else {
                bw.append(second[sIdx++] + " ");
            }
        }
        while (fIdx < N) bw.append(first[fIdx++] + " ");
        while (sIdx < M) bw.append(second[sIdx++] + " ");
        bw.flush();
    }
}
