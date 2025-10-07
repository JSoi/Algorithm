package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1749 {
    static int[][] dp, arr;
    static int N, M;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        dp = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
    public static void main(String[] args) throws IOException {
        input();
        int max = Integer.MIN_VALUE;
        for (int left = 0; left < M; left++) {
            int[] temp = new int[N];
            for (int right = left; right < M; right++) {
                for (int row = 0; row < N; row++) {
                    temp[row] += arr[row][right];
                }
                max = Math.max(max, kadane(temp));
            }
        }
        System.out.println(max);
    }

    static int kadane(int[] arr) {
        int max = arr[0];
        int sum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sum = Math.max(arr[i], sum + arr[i]);
            max = Math.max(max, sum);
        }
        return max;
    }
}
