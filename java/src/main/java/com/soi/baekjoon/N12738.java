package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N12738 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int len = 0;
        long[] arr = new long[n];
        long[] lis = new long[n];
        StringTokenizer tok = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(tok.nextToken());
        }
        for (int i = 0; i < n; i++) {
            int pos = Arrays.binarySearch(lis, 0, len, arr[i]);
            pos = pos < 0 ? -(pos + 1) : pos;
            lis[pos] = arr[i];
            if (pos == len) len++;
        }
        System.out.println(len);
    }
}
