package com.soi.leetcode;

public class LC_spiral_matrix_ii {
    public int[][] generateMatrix(int n) {
        // (0, 1) -> (1, 0) -> (0, -1) -> (-1, 0)
        int dx = 0;
        int dy = 1;
        int count = 0;
        int[] curr = new int[]{0, 0};
        int[][] answer = new int[n][n];
        while (count < n * n) {
            count++;
            answer[curr[0]][curr[1]] = count;
            int nextX = curr[0] + dx;
            int nextY = curr[1] + dy;
            if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n || answer[nextX][nextY] != 0) {
                int tmp = dx;
                dx = dy;
                dy = -tmp;
            }
            curr[0] += dx;
            curr[1] += dy;
        }
        return answer;
    }
}
