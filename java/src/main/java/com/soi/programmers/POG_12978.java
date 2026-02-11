package com.soi.programmers;

import java.util.Arrays;
import java.util.stream.IntStream;

public class POG_12978 {
    public static void main(String[] args) {
        int solution = new POG_12978().solution(5, new int[][]{{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}}, 3);
        System.out.println(solution);
    }

    public int solution(int N, int[][] road, int K) {
        int[][] matrix = new int[N][N];
        Arrays.stream(matrix).forEach(m -> Arrays.fill(m, Integer.MAX_VALUE));
        IntStream.range(0, N).forEach(i -> matrix[i][i] = 0);
        for (int[] r : road) {
            int min = Math.min(r[2], matrix[r[0] - 1][r[1] - 1]);
            matrix[r[0] - 1][r[1] - 1] = matrix[r[1] - 1][r[0] - 1] = min;
        }
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (matrix[i][k] == Integer.MAX_VALUE || matrix[k][j] == Integer.MAX_VALUE)
                        continue;
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }
        return (int) Arrays.stream(matrix[0]).filter(m -> m <= K).count();
    }
}
