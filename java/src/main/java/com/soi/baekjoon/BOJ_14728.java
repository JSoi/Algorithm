package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_14728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] problems = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            problems[i][0] = Integer.parseInt(st.nextToken());
            problems[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(problems, Comparator.comparingInt(o -> o[0]));
        int[] dp = new int[K + 1];
        for (int i = 0; i < N; i++) {
            int time = problems[i][0];
            int score = problems[i][1];

            for (int j = K; j >= time; j--) {
                dp[j] = Math.max(dp[j], dp[j - time] + score);
            }
        }
        System.out.println(dp[K]);
    }

}
