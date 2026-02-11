package com.soi.programmers;

import java.util.Arrays;

public class POG_92344 {
    public static void main(String[] args) {
        System.out.println(new POG_92344().solution(
                new int[][]{
                        {5, 5, 5, 5, 5},
                        {5, 5, 5, 5, 5},
                        {5, 5, 5, 5, 5},
                        {5, 5, 5, 5, 5}
                },
                new int[][]{
                        {1, 0, 0, 3, 4, 4},
                        {1, 2, 0, 2, 3, 2},
                        {2, 1, 0, 3, 1, 2},
                        {1, 0, 1, 3, 3, 1}
                }
        ));

    }

    public int solution(int[][] board, int[][] skill) {
        int row = board.length;
        int col = board[0].length;
        // Arrays.sort(skill, (s1, s2) -> s1[0] == s2[0] ? s1[1] - s2[1] : s1[0] - s2[0]);
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                for (int[] s : skill) {
                    if (s[1] > r || s[3] < r || s[2] > c || s[4] < c) {
                        continue;
                    }
                    board[r][c] += (s[0] == 1 ? -s[5] : s[5]);
                }
            }
        }
        return (int) Arrays.stream(board).flatMapToInt(Arrays::stream).filter(i -> i > 0).count();
    }
}
