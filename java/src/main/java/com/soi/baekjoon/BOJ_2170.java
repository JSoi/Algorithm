package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2170 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] l = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(tok.nextToken());
            int y = Integer.parseInt(tok.nextToken());
            l[i][0] = x;
            l[i][1] = y;
        }
        Arrays.sort(l, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        int start = l[0][0], end = l[0][1];
        int answer = 0;
        for (int i = 1; i < n; i++) {
            if (l[i][0] <= end) {
                end = Math.max(end, l[i][1]);
            } else {
                answer += end - start;
                start = l[i][0];
                end = l[i][1];
            }
        }
        answer += end - start;
        System.out.println(answer);
    }
}
