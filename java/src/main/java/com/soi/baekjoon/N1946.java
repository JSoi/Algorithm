package com.soi.baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class N1946 {
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
            int answer = 0;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (arr[i][1] < min) {
                    answer++;
                    min = arr[i][1];
                }
            }
            bw.write(answer + "\n");
        }
        bw.flush();
    }
}
