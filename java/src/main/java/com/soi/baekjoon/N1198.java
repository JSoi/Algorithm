package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * <a href = "https://www.acmicpc.net/problem/1198">삼각형으로 자르기</a>
 */
public class N1198 {
    private static double answer;
    private static int[][] input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseCount = Integer.parseInt(br.readLine());
        input = new int[caseCount][2];
        for (int i = 0; i < caseCount; i++) {
            String[] line = br.readLine().split(" ");
            input[i] = new int[]{Integer.parseInt(line[0]), Integer.parseInt(line[1])};
        }
        int[][] local = new int[3][2];
        getMaxDimension(0, 0, local);
        System.out.println(answer);
    }

    // 시계 방향으로 주어짐
    private static double getDimension(int a1, int a2, int b1, int b2, int c1, int c2) {
        // 기울기
        double a = getLength(a1, a2, b1, b2);
        double b = getLength(b1, b2, c1, c2);
        double c = getLength(a1, a2, c1, c2);
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    private static double getLength(int a1, int a2, int b1, int b2) {
        return Math.sqrt(Math.pow(a1 - b1, 2) + Math.pow(a2 - b2, 2));
    }

    // 조합
    private static void getMaxDimension(int start, int r, int[][] c) {
        if (r == 3) {
            if (start >= input.length + 1) {
                return;
            }
            answer = Math.max(answer, getDimension(c[0][0], c[0][1], c[1][0], c[1][1], c[2][0], c[2][1]));
            return;
        }
        for (int i = start; i < input.length; i++) {
            c[r] = Arrays.copyOf(input[i], 2);
            getMaxDimension(i + 1, r + 1, c);
        }
    }
}
