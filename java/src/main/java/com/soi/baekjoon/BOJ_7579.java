package com.soi.baekjoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_7579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int maxCost = 100 * N;

        int[][] app = new int[N][2];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) { // mem
            app[i][0] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) { // reactivate
            app[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[maxCost + 1];

        for (int i = 0; i < N; i++) {
            for (int j = maxCost; j >= app[i][1]; j--) {
                dp[j] = Math.max(dp[j], dp[j - app[i][1]] + app[i][0]);
            }
        }
        int answer = 0;
        for (int d : dp) {
            if (d >= M) {
                break;
            }
            answer++;
        }
        System.out.println(answer);
    }
}

