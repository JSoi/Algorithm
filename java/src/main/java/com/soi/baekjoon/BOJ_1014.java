package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_1014 {
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
        System.out.print(sb);

    }

    static class ClassRoom {
        int r;
        int c;
        int[][] dp;
        List<Integer>[] validMasks;
        boolean[][] map;

        public ClassRoom(int r, int c, boolean[][] map) {
            this.r = r;
            this.c = c;
            this.map = map;
            dp = new int[r][1 << c];
            validMasks = new List[r];
            buildValidMasks();
        }

        public int dp() {
            int answer = 0;
            for (int mask : validMasks[0]) {
                dp[0][mask] = Integer.bitCount(mask);
                answer = Math.max(answer, dp[0][mask]);
            }
            // DP 수행
            for (int row = 1; row < r; row++) {
                for (int currMask : validMasks[row]) {
                    for (int prevMask : validMasks[row - 1]) {
                        if ((currMask & (prevMask << 1)) == 0 && (currMask & (prevMask >> 1)) == 0) {
                            dp[row][currMask] = Math.max(dp[row][currMask], dp[row - 1][prevMask] + Integer.bitCount(currMask));
                            answer = Math.max(answer, dp[row][currMask]);
                        }
                    }
                }
            }
            return answer;
        }

        public void buildValidMasks() {
            for (int row = 0; row < r; row++) {
                validMasks[row] = new ArrayList<>();
                for (int mask = 0; mask < (1 << c); mask++) {
                    boolean isValid = true;

                    for (int col = 0; col < c; col++) {
                        if (((mask >> col) & 1) == 1) {
                            if (!map[row][col]) {
                                isValid = false;
                                break;
                            }
                            if (col > 0 && ((mask >> (col - 1)) & 1) == 1) {
                                isValid = false;
                                break;
                            }
                        }
                    }
                    if (isValid) {
                        validMasks[row].add(mask);
                    }
                }
            }
        }
    }
}
