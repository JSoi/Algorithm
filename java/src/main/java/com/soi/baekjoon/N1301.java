package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * <a href = "https://www.acmicpc.net/problem/1301">비즈 공예</a>
 */
public class N1301 {
    static int beadColorCount;
    static int[] beadArr;
    static long[][][][][][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        beadColorCount = Integer.parseInt(br.readLine()); // [3,5]
        beadArr = new int[5];
        for (int b = 0; b < beadColorCount; b++) {
            int count = Integer.parseInt(br.readLine());
            beadArr[b] = count;
        }
        int MAX = 12; // 각 구슬 수가 최대 12
        dp = new long[MAX][MAX][MAX][MAX][MAX][6][6];
        for (int a = 0; a < MAX; a++)
            for (int b = 0; b < MAX; b++)
                for (int c = 0; c < MAX; c++)
                    for (int d = 0; d < MAX; d++)
                        for (int e = 0; e < MAX; e++)
                            for (int l = 0; l < 6; l++)
                                for (int cnt = 0; cnt < 6; cnt++)
                                    dp[a][b][c][d][e][l][cnt] = -1;
        System.out.println(dfs(5, 5));
    }

    static long dfs(int last1, int last2) {
        if (Arrays.stream(beadArr).sum() == 0L) return 1;
        long status = dp[beadArr[0]][beadArr[1]][beadArr[2]][beadArr[3]][beadArr[4]][last1][last2];
        if (status != -1)
            return status;
        long res = 0;
        for (int i = 0; i < beadColorCount; i++) {
            if (beadArr[i] == 0 || i == last1 || i == last2) continue;
            beadArr[i]--;
            res += dfs(i, last1);
            beadArr[i]++;
        }
        dp[beadArr[0]][beadArr[1]][beadArr[2]][beadArr[3]][beadArr[4]][last1][last2] = res;
        return res;
    }
}
