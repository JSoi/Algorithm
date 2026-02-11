package com.soi.baekjoon;

import java.io.*;
import java.util.Arrays;

public class BOJ_1485 {
    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int caseCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < caseCount; i++) {
            int[][] dots = new int[4][2];
            for (int j = 0; j < 4; j++) {
                int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                dots[j][0] = line[0];
                dots[j][1] = line[1];
            }
            bw.append(new Problem(dots).isSquare() ? "1" : "0").append("\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }

    static class Problem {
        int[][] dots;

        Problem(int[][] dots) {
            this.dots = dots;
            Arrays.sort(dots, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        }

        public boolean isSquare() {
            double between = getPowSum(dots[0], dots[1]);
            if (getPowSum(dots[0], dots[2]) != between || getPowSum(dots[3], dots[1]) != between || getPowSum(dots[3], dots[2]) != between) {
                return false;
            }
            if (getPowSum(dots[0], dots[3]) != getPowSum(dots[1], dots[2])) {
                return false;
            }
            return getPowSum(dots[0], dots[1]) + getPowSum(dots[0], dots[2]) ==
                    getPowSum(dots[3], dots[1]) + getPowSum(dots[3], dots[2]);
        }

        private int getPow(int d1, int d2) {
            return (d1 - d2) * (d1 - d2);
        }

        private int getPowSum(int[] d1, int[] d2) {
            return getPow(d1[0], d2[0]) + getPow(d1[1], d2[1]);
        }
    }

}
