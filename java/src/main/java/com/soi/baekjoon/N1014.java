package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1014 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int testCase = 0; testCase < testCases; testCase++) {
            String[] nm = br.readLine().split(" ");
            int r = Integer.parseInt(nm[0]);
            int c = Integer.parseInt(nm[1]);
            boolean[][] map = new boolean[r][c];
            for (int i = 0; i < r; i++) {
                String line = br.readLine();
                for (int j = 0; j < c; j++) {
                    map[i][j] = line.charAt(j) == '.';
                }
            }
            ClassRoom classRoom = new ClassRoom(r, c, map);
            sb.append(classRoom.dp()).append('\n');
        }
        System.out.println(sb);

    }

    static class ClassRoom {
        int r;
        int c;
        int[] sum;
        int[][] dp;

        public ClassRoom(int r, int c, boolean[][] map) {
            this.r = r;
            this.c = c;
            sum = new int[c];
            dp = new int[c][2];
            count(map);

        }

        public int dp() {
            dp[0][1] = sum[0];
            int answer = dp[0][1];
            for (int i = 1; i < c; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
                dp[i][1] = Math.max(dp[i - 1][0] + sum[i], dp[i - 1][1]);
                answer = Math.max(answer, Math.max(dp[i][0], dp[i][1]));
            }
            return answer;
        }

        public void count(boolean[][] map) {
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (map[i][j]) {
                        sum[j]++;
                    }
                }
            }
        }
    }
}
