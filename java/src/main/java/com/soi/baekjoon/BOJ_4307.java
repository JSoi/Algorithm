package com.soi.baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_4307 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            int min = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(br.readLine());
                min = Math.max(min, Math.min(arr[i], Math.abs(arr[i] - l)));
            }
            Arrays.sort(arr);

            int max = Math.max(arr[0], l - arr[0]);
            for (int i = 1; i < n; i++) {
                int leftDiff = arr[i] - arr[i - 1];
                int rightDist = l - arr[i];
                int rightDiff = i == n - 1 ? 0 : (arr[i] - arr[i + 1]);
                int leftDist = arr[i];
                max = Math.max(max, Math.max(rightDist + leftDiff, leftDist + rightDiff));
            }
            bw.write(min + " " + max + "\n");
        }
        bw.flush();
    }
}
