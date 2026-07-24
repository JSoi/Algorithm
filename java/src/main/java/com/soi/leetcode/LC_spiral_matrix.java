package com.soi.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC_spiral_matrix {
    private static final int[][] direction = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public List<Integer> spiralOrder(int[][] matrix) {
        int dir = 0;
        int m = matrix.length, n = matrix[0].length;
        boolean[][] visit = new boolean[m][n];
        int count = 0;
        int r = 0, c = 0;
        List<Integer> answer = new ArrayList<>();
        while (count < m * n) {
            visit[r][c] = true;
            answer.add(matrix[r][c]);

            int nextR = direction[dir][0] + r;
            int nextC = direction[dir][1] + c;
            if (nextR < 0 || nextC < 0 || nextR >= m || nextC >= n || visit[nextR][nextC]) {
                dir = (dir + 1) % 4;
                nextR = direction[dir][0] + r;
                nextC = direction[dir][1] + c;
            }
            r = nextR;
            c = nextC;
            count++;
        }
        return answer;
    }
}
