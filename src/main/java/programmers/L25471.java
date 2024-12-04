package programmers;

import java.util.Arrays;

public class L25471 {
    public int solution(int[][] board, int[][] skill) {
        int row = board.length;
        int col = board[0].length;
        int[][] accumulativeSum = new int[row][col];
        for (int[] s : skill) {
            int acc = (s[0] == 1 ? -s[5] : s[5]);
            accumulativeSum[s[1]][s[2]] += acc;
            if (s[3] + 1 < row && s[4] + 1 < col) {
                accumulativeSum[s[3] + 1][s[4] + 1] += acc;
                accumulativeSum[s[3] + 1][s[2]] -= acc;
                accumulativeSum[s[1]][s[4] + 1] -= acc;
            } else if (s[3] + 1 < row) {
                accumulativeSum[s[3] + 1][s[2]] -= acc;
            } else if (s[4] + 1 < col) {
                accumulativeSum[s[1]][s[4] + 1] -= acc;
            }
        }

        for (int r = 0; r < row; r++) {
            for (int c = 1; c < col; c++) {
                accumulativeSum[r][c] += accumulativeSum[r][c - 1];
            }
        }
        for (int c = 0; c < col; c++) {
            for (int r = 1; r < row; r++) {
                accumulativeSum[r][c] += accumulativeSum[r - 1][c];
            }
        }
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                board[r][c] += accumulativeSum[r][c];
            }
        }
        return (int) Arrays.stream(board).flatMapToInt(Arrays::stream).filter(i -> i > 0).count();
    }
}
