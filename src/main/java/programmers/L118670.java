package programmers;

import java.util.Arrays;

public class L118670 {
    static int row;
    static int col;
    static int[][][] status;

    public static int[][] solution(int[][] rc, String[] operations) {
        row = rc.length;
        col = rc[0].length;
        status = new int[row][col][2];
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                for (String o : operations) {
                    if (o.equals("Rotate")) {
                        rotate(r, c);
                    } else {
                        shift(r, c);
                    }
                }
            }
        }
        int[][] answer = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                answer[i + status[i][j][0]][j + status[i][j][1]] = rc[i][j];
            }
        }
        return answer;
    }

    static void rotate(int r, int c) {
        int currentR = status[r][c][0] + r;
        int currentC = status[r][c][1] + c;
        if (currentR != 0 && currentC != 0 && currentR != row - 1 && currentC != col - 1) {
            return;
        }
        if (currentR == 0) {
            status[r][c][(currentC == col - 1) ? 0 : 1]++;
        } else if (currentC == col - 1) {
            if (currentR == row - 1) {
                status[r][c][1]--;
            } else {
                status[r][c][0]++;
            }
        } else if (currentR == row - 1) {
            if (currentC == 0) {
                status[r][c][0]--;
            } else {
                status[r][c][1]--;
            }
        } else if (currentC == 0) {
            status[r][c][0]--;
        }
    }

    static void shift(int r, int c) {
        int currentR = status[r][c][0] + r;
        if (currentR == row - 1) {
            status[r][c][0] -= (row - 1);
        } else {
            status[r][c][0]++;
        }
    }
}
