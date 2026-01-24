package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N12869 {
    static final int[][] OFFSETS = {
            {9, 3, 1}, {9, 1, 3},
            {3, 9, 1}, {3, 1, 9},
            {1, 9, 3}, {1, 3, 9}
    };
    private static int n, answer;
    private static int[] healths;
    private static int[][][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        healths = new int[3];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            healths[i] = Integer.parseInt(st.nextToken());
        }
        answer = Integer.MAX_VALUE;
        visit = new int[61][61][61];
        for (int i = 0; i <= 60; i++) {
            for (int j = 0; j <= 60; j++) {
                for (int k = 0; k <= 60; k++) {
                    visit[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }
        dp(healths, 0);
        System.out.println(answer);
    }

    private static void dp(int[] current, int trialCount) {
        if (trialCount >= answer) return;
        if (visit[current[0]][current[1]][current[2]] <= trialCount) {
            return;
        }
        visit[current[0]][current[1]][current[2]] = trialCount;
        if (current[0] == 0 && current[1] == 0 && current[2] == 0) {
            answer = Math.min(answer, trialCount);
            return;
        }
        for (int[] o : OFFSETS) {
            int[] next = new int[3];
            next[0] = Math.max(0, current[0] - o[0]);
            next[1] = Math.max(0, current[1] - o[1]);
            next[2] = Math.max(0, current[2] - o[2]);
            dp(next, trialCount + 1);
        }
    }
}
