package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N14718 {
    private static int n, k;
    private static int[][] arr;
    private static int answer = Integer.MAX_VALUE;
    private static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(tok.nextToken());
        k = Integer.parseInt(tok.nextToken());
        arr = new int[n][3];
        visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            tok = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(tok.nextToken());
            }
        }
        dp(0, 0, 0, 0, 0);
        System.out.println(answer);
    }

    static void dp(int soldierIdx, int a, int b, int c, int chooseCount) {
        if (chooseCount == k) {
            answer = Math.min(answer, a + b + c);
            return;
        }
        if (soldierIdx >= n)
            return;
        for (int i = soldierIdx; i < n; i++) {
            if (visit[i]) {
                continue;
            }
            visit[i] = true;
            int nextA = Math.max(a, arr[i][0]);
            int nextB = Math.max(b, arr[i][1]);
            int nextC = Math.max(c, arr[i][2]);
            if (nextA + nextB + nextC >= answer) {
                continue;
            }
            dp(i, nextA, nextB, nextC, chooseCount + 1);
            visit[i] = false;
        }
    }
}
