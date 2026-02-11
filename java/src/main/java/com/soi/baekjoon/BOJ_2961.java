package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2961 {
    private static long[][] ingredients;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        ingredients = new long[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            ingredients[i][0] = Integer.parseInt(st.nextToken());
            ingredients[i][1] = Integer.parseInt(st.nextToken());
        }
        long answer = Long.MAX_VALUE;
        for (int s = 1; s < Math.pow(2, n); s++) {
            answer = Math.min(answer, diff(s));
        }
        System.out.println(answer);
    }

    private static long diff(int status) {
        long sour = 1;
        long bitter = 0;
        for (int i = 0; i < n; i++) {
            if ((status & (1 << i)) == 0) {
                continue;
            }
            sour *= ingredients[i][0];
            bitter += ingredients[i][1];
        }
        return Math.abs(sour - bitter);
    }
}
