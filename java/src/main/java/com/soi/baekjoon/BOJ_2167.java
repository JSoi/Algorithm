package com.soi.baekjoon;

import java.io.*;
import java.util.Arrays;

public class BOJ_2167 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int row = input[0];
        int col = input[1];
        int[][] map = new int[row][col];
        long[][] cumulative = new long[row + 1][col + 1];
        for (int r = 0; r < row; r++) {
            map[r] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        for (int r = 1; r <= row; r++) {
            for (int c = 1; c <= col; c++) {
                cumulative[r][c] = map[r - 1][c - 1] + cumulative[r - 1][c] + cumulative[r][c - 1] - cumulative[r - 1][c - 1];
            }
        }
        int caseCount = Integer.parseInt(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int c = 0; c < caseCount; c++) {
            int[] ii = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            bw.append(String.valueOf(getCumulativeSum(ii[0], ii[1], ii[2], ii[3], cumulative))).append("\n");
        }
        bw.flush();
    }

    private static long getCumulativeSum(int fromR, int fromC, int toR, int toC, long[][] cumulativeSumArr) {
        fromR--;
        fromC--;
        return cumulativeSumArr[toR][toC] - cumulativeSumArr[toR][fromC] - cumulativeSumArr[fromR][toC] + cumulativeSumArr[fromR][fromC];
    }
}
