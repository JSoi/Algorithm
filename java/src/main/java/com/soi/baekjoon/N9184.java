package com.soi.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class N9184 {
    private static int[][][] dp = new int[51][51][51];
    private static final String format = "w(%d, %d, %d) = %d\n";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        dp[0][0][0] = 1;
        while (true) {
            StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(tok.nextToken());
            int b = Integer.parseInt(tok.nextToken());
            int c = Integer.parseInt(tok.nextToken());
            if (a == -1 && b == -1 && c == -1) break;
            bw.append(String.format(format, a, b, c, calculate(a, b, c)));
        }
        bw.flush();
    }

    private static int calculate(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0)
            return dp[0][0][0];
        if (dp[a][b][c] != 0)
            return dp[a][b][c];
        if (a > 20 || b > 20 || c > 20)
            return calculate(20, 20, 20);
        if (a < b && b < c)
            return dp[a][b][c] = calculate(a, b, c - 1) + calculate(a, b - 1, c - 1) - calculate(a, b - 1, c);
        return dp[a][b][c] = calculate(a - 1, b, c) + calculate(a - 1, b - 1, c) + calculate(a - 1, b, c - 1) - calculate(a - 1, b - 1, c - 1);
    }
}
