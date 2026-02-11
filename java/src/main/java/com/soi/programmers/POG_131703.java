package com.soi.programmers;

public class POG_131703 {
    private static int row, col, answer;
    private static boolean[][] current, toBe;

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{1}, {0}}, new int[][]{{1}, {1}}));
    }

    public static int solution(int[][] beginning, int[][] target) {
        answer = Integer.MAX_VALUE;
        row = beginning.length;
        col = beginning[0].length;
        current = toCoin(beginning);
        toBe = toCoin(target);
        go(0, new boolean[row + col]);
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    public static void go(int idx, boolean[] v) {
        if (idx >= row + col) {
//            System.out.println(Arrays.toString(v));
            if (isIdentical()) {
                int count = 0;
                for (boolean b : v) {
                    if (b) {
                        count++;
                    }
                }
                answer = Math.min(answer, count);
            }
            return;
        }
        v[idx] = true;
        flip(idx >= row ? idx - row : idx, idx < row, current);
        go(idx + 1, v);
        flip(idx >= row ? idx - row : idx, idx < row, current);
        v[idx] = false;
        go(idx + 1, v);
    }

    private static void flip(int index, boolean isRow, boolean[][] coins) {
        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j < coins[0].length; j++) {
                if (isRow) {
                    if (i == index) {
                        coins[i][j] = !coins[i][j];
                    }
                } else {
                    if (j == index) {
                        coins[i][j] = !coins[i][j];
                    }
                }
            }
        }
    }

    private static boolean[][] toCoin(int[][] coins) {
        boolean[][] newCoin = new boolean[coins.length][coins[0].length];
        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j < coins[0].length; j++) {
                newCoin[i][j] = coins[i][j] == 1;
            }
        }
        return newCoin;
    }

    private static boolean isIdentical() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (current[i][j] != toBe[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
