package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1074 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = (int) Math.pow(2, Integer.parseInt(line[0]));
        int row = Integer.parseInt(line[1]);
        int col = Integer.parseInt(line[2]);
        int answer = 0;
        while (N > 1) {
            N /= 2;
            int val = getCount(row / N, col / N) * N * N;
            answer += val;
            row %= N;
            col %= N;
        }
        System.out.println(answer);
    }

    private static int getCount(int row, int col) {
        if (row == 0 && col == 1) {
            return 1;
        } else if (row == 1 && col == 0) {
            return 2;
        } else if (row == 1 && col == 1) {
            return 3;
        }
        return 0;
    }
}
