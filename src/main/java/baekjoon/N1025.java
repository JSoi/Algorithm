package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1025 {
    static int answer;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int row = Integer.parseInt(input[0]);
        int col = Integer.parseInt(input[1]);

        arr = new int[row][col];
        for (int i = 0; i < row; i++) {
            String[] rowInput = br.readLine().split("");
            for (int j = 0; j < col; j++) {
                arr[i][j] = Integer.parseInt(rowInput[j]);
            }
        }

        answer = -1;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (isSquare(arr[r][c])) { // 하나의 선택에 대해서도 체크
                    answer = Math.max(answer, arr[r][c]);
                }
                int max = Math.max(row, col);
                for (int ro = -max; ro <= max; ro++) {
                    for (int co = -max; co <= max; co++) {
                        if (ro == 0 && co == 0) {
                            continue;
                        }
                        updateSquareNum(r, c, ro, co);
                    }
                }
            }
        }
        System.out.println(answer);
    }

    static void updateSquareNum(int r, int c, int ro, int co) {
        int br = r + ro;
        int bc = c + co;
        if (bc < 0 || bc >= arr[0].length || br < 0 || br >= arr.length) {
            return;
        }
        long num = 0;
        int nr = r;
        int nc = c;
        while (nr >= 0 && nr < arr.length && nc >= 0 && nc < arr[0].length) {
            num = num * 10 + arr[nr][nc];
            if (isSquare(num)) {
                answer = Math.max(answer, (int) num);
            }
            nr += ro;
            nc += co;
        }
    }

    static boolean isSquare(long num) {
        if (num < 0) {
            return false;
        }
        long sqrt = (long) Math.sqrt(num);
        return sqrt * sqrt == num;
    }
}
