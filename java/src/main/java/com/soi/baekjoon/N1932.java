package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(buf.readLine());
        int[][] input = new int[cnt + 1][cnt + 1];
        for (int i = 0; i < cnt; i++) {
            StringTokenizer tok = new StringTokenizer(buf.readLine());
            for (int j = 0; j <= i; j++) {
                input[i][j] = Integer.parseInt(tok.nextToken());
            }
        }
        int[] sum = new int[cnt + 1];
        for (int i = cnt - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                sum[j] = Math.max(sum[j + 1], sum[j]) + input[i][j];
            }
        }
        System.out.println(sum[0]);
    }
}
