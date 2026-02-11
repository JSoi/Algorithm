package com.soi.programmers;

import java.util.Arrays;

public class POG_81302 {
    private static final int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    private static final int[][] diagonalPairs = {{-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

    public static void main(String[] args) {
        int[] solution = new POG_81302().solution(new String[][]
                {
                        {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                        {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                        {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                        {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                        {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
                });
        System.out.println(Arrays.toString(solution));
    }

    private static boolean isSafe(char[][] places) {
        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                if (places[r][c] != 'P') {
                    continue;
                }

                for (int[] dir : directions) {
                    int nextR = r + dir[0];
                    int nextC = c + dir[1];
                    if (isValid(nextR, nextC) && places[nextR][nextC] == 'P') {
                        return false;
                    }
                }

                for (int[] dir : directions) {
                    int nextR = r + 2 * dir[0];
                    int nextC = c + 2 * dir[1];
                    int midR = r + dir[0];
                    int midC = c + dir[1];
                    if (isValid(nextR, nextC) && places[nextR][nextC] == 'P' && places[midR][midC] == 'O') {
                        return false;
                    }
                }

                for (int[] dir : diagonalPairs) {
                    int nextR = r + dir[0];
                    int nextC = c + dir[1];
                    if (isValid(nextR, nextC) && places[nextR][nextC] == 'P' && (places[r + dir[0]][c] == 'O' || places[r][c + dir[1]] == 'O')) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static boolean isValid(int row, int col) {
        return row >= 0 && row < 5 && col >= 0 && col < 5;
    }

    public int[] solution(String[][] places) {
        return Arrays.stream(places).mapToInt(s -> isSafe(Arrays.stream(s).map(String::toCharArray).toArray(char[][]::new)) ? 1 : 0).toArray();
    }
}
