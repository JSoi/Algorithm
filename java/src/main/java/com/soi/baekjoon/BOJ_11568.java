package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_11568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        ArrayList<Integer> LIS = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < n; i++) {
            int pos = Collections.binarySearch(LIS, arr[i]);
            pos = pos < 0 ? -pos - 1 : pos;
            if (pos < LIS.size()) {
                LIS.set(pos, arr[i]);
            } else {
                LIS.add(arr[i]);
            }
            max = Math.max(max, LIS.size());
        }
        System.out.println(max);
    }
}
