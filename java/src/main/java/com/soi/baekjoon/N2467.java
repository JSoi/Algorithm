package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N2467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
        long min = Long.MAX_VALUE;
        int l = 0;
        int r = 0;
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(tok.nextToken());
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                long abs = Math.abs(arr[i] + arr[j]);
                if (abs > min) {
                    continue;
                }
                l = i;
                r = j;
                min = abs;
            }
        }
        System.out.println(arr[l] + " " + arr[r]);
    }
}
