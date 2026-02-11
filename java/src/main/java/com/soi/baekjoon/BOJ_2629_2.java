package com.soi.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2629_2 {
    private static final int MAX = 15_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] weight = new int[N + 1];
        StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            weight[i] = Integer.parseInt(tok.nextToken());
        }
        boolean[] sum = new boolean[MAX + 1];
        boolean[] diff = new boolean[MAX + 1];

        for (int i = 1; i <= N; i++) {
            int ww = weight[i];
            boolean[] nextSum = new boolean[MAX + 1];
            boolean[] nextDiff = new boolean[MAX + 1];

            for (int w = 0; w <= MAX; w++) {
                if (sum[w]) {
                    if (w + ww <= MAX) nextSum[w + ww] = true;
                    nextDiff[Math.abs(w - ww)] = true;
                }
                if (diff[w]) {
                    if (w + ww <= MAX) nextDiff[w + ww] = true;
                    nextDiff[Math.abs(w - ww)] = true;
                }
            }
            nextSum[ww] = true;
            for (int w = 0; w <= MAX; w++) {
                sum[w] |= nextSum[w];
                diff[w] |= nextDiff[w];
            }
        }
        int cases = Integer.parseInt(br.readLine());
        tok = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < cases; i++) {
            int c = Integer.parseInt(tok.nextToken());
            boolean doesMatch = sum[c] || diff[c];
            bw.write((doesMatch ? "Y" : "N") + " ");
        }
        bw.flush();
    }
}
