package com.soi.baekjoon;

import java.io.*;
import java.util.Arrays;

public class BOJ_11062 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int gScore = new TestCase(arr).getGScore();
            bw.write(gScore + "\n");
        }
        bw.flush();
    }

    private static class TestCase {
        private int gScore = 0;
        private int[] arr;
        private int[][] dp;
        private int n;

        public TestCase(int[] arr) {
            this.arr = arr;
            this.n = arr.length;
            this.dp = new int[n][n];
            for (int[] dd : dp) {
                Arrays.fill(dd, -1);
            }
            if (n == 1) {
                gScore = arr[0];
                return;
            }

            gScore = score(0, n - 1, 0);;
        }

        public int getGScore() {
            return gScore;
        }

        private int score(int l, int r, int turn) {
            if (l > r) {
                return 0;
            }
            if (dp[l][r] != -1) {
                return dp[l][r];
            }
            int curr;
            int nextL = score(l + 1, r, (turn + 1) % 2);
            int nextR = score(l, r - 1, (turn + 1) % 2);
            if (turn % 2 == 0) {
                curr = Math.max(arr[l] + nextL, arr[r] + nextR);
            } else {
                curr = Math.min(nextL, nextR);
            }
            return dp[l][r] = curr;
        }
    }
}
