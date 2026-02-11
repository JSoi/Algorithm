package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1365 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < arr.length; i++) {
            int number = Integer.parseInt(tok.nextToken());
            arr[i] = number;
        }
        List<Integer> lis = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int num = arr[i];
            int idx = Collections.binarySearch(lis, num);
            if (idx < 0) idx = -(idx + 1);
            if (idx >= lis.size()) lis.add(num);
            else lis.set(idx, num);
        }
        System.out.println(n - lis.size());
    }
}
