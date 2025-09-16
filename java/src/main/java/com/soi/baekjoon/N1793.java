package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class N1793 {
    public static final int MAX = 250;

    public static void main(String[] args) throws IOException {
        BigDecimal[] dp = new BigDecimal[MAX + 1];
        dp[0] = dp[1] = BigDecimal.ONE;
        dp[2] = BigDecimal.valueOf(3);
        for (int i = 3; i <= MAX; i++) {
            dp[i] = dp[i - 1].add(dp[i - 2].multiply(BigDecimal.valueOf(2)));
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String line = br.readLine();
            if (line == null || line.isBlank()) break;
            int n = Integer.parseInt(line);
            System.out.println(dp[n].toPlainString());
        }
    }
}
