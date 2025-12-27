package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N2437 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        boolean[] possible = new boolean[1_000_001];
        for (int i = 0; i < n; i++) {
            possible[arr[i]] = true;
//            System.out.println(arr[i]);
            for (int num = 1; num <= 1_000_000; num++) {
                if (possible[num]) {
                    if (num + arr[i] <= 1_000_000)
                        possible[num + arr[i]] = true;
                } else if (num < arr[i]) {
                    System.out.println(num);
                    return;
                }
            }
        }
    }
}
