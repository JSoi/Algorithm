package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1256 {
    static final int MAX = 201;
    static final int LIMIT = 1_000_000_001;
    static long[][] dp = new long[MAX][MAX];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);  // 'a'
        int z = Integer.parseInt(input[1]);  // 'z'
        long k = Long.parseLong(input[2]);

        for (int i = 0; i <= a; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j <= z; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= z; j++) {
                dp[i][j] = Math.min(LIMIT, dp[i - 1][j] + dp[i][j - 1]);
            }
        }

        if (dp[a][z] < k) {
            System.out.println(-1);
            return;
        }

        StringBuilder sb = new StringBuilder();
        while (a > 0 || z > 0) {
            if (a == 0) {
                sb.append('z');
                z--;
            } else if (z == 0) {
                sb.append('a');
                a--;
            } else {
                long count = dp[a - 1][z]; // a 수를 줄인 수와 비교
                if (k <= count) {
                    sb.append('a');
                    a--;
                } else {
                    sb.append('z');
                    k -= count;
                    z--;
                }
            }
        }
        System.out.println(sb);
    }
}
