package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2618 {
    static final int IMP = Integer.MAX_VALUE;
    static final int MAX = IMP;
    static int[][] cases;
    static int[][] dp;
    static int n, c;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(solve(0, 0));
        track(0, 0);
        System.out.println(sb);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        c = Integer.parseInt(br.readLine());
        dp = new int[c + 1][c + 1];
        cases = new int[c + 1][2];
        for (int i = 1; i <= c; i++) {
            String[] line = br.readLine().split(" ");
            int r = Integer.parseInt(line[0]);
            int c = Integer.parseInt(line[1]);
            cases[i][0] = r;
            cases[i][1] = c;
        }
        for (int[] d : dp) {
            Arrays.fill(d, MAX);
        }
    }

    private static int solve(int a, int b) {
        int next = Math.max(a, b) + 1;
        if (next > c) return 0;

        if (dp[a][b] != MAX) return dp[a][b];

        int dist1 = getDist(a, next, true);
        int dist2 = getDist(b, next, false);

        int move1 = solve(next, b) + dist1; // 1번 경찰차가 next 해결
        int move2 = solve(a, next) + dist2; // 2번 경찰차가 next 해결

        return dp[a][b] = Math.min(move1, move2);
    }

    private static int getDist(int last, int next, boolean isFirstPolice) {
        int lastR, lastC;
        if (last == 0) {
            lastR = lastC = (isFirstPolice ? 1 : n);
        } else {
            lastR = cases[last][0];
            lastC = cases[last][1];
        }
        return Math.abs(lastR - cases[next][0]) + Math.abs(lastC - cases[next][1]);
    }

    private static void track(int a, int b) {
        int next = Math.max(a, b) + 1;
        if (next > c) return;
        int dist = getDist(a, next, true);
        int move = solve(next, b) + dist;
        if (dp[a][b] == move) {
            sb.append("1\n");
            track(next, b);
        } else {
            sb.append("2\n");
            track(a, next);
        }
    }

}
