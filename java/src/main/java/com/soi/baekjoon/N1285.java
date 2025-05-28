package com.soi.baekjoon;

import java.util.Scanner;

public class N1285 {

    static boolean[][] isFront;
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());
        isFront = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            char[] charArray = sc.nextLine().toCharArray();
            for (int j = 0; j < N; j++) {
                char c = charArray[j];
                if (c == 'T') { // 윗면
                    isFront[i][j] = true;
                }
            }
        }
        int answer = getMin();
        System.out.println(answer);
    }

    private static int getMin() {
        int answer = Integer.MAX_VALUE;
        for (int rowMask = 0; rowMask < (1 << N); rowMask++) {
            int totalFrontCount = 0;
            for (int col = 0; col < N; col++) {
                int colFrontCount = 0;
                for (int row = 0; row < N; row++) {
                    boolean isFlipped = ((rowMask >> row) & 1) == 1;
                    boolean cell = isFront[row][col];
                    if (isFlipped) cell = !cell;

                    if (cell) colFrontCount++;
                }
                totalFrontCount += Math.min(colFrontCount, N - colFrontCount);
            }
            answer = Math.min(answer, totalFrontCount);
        }
        return answer;
    }

}
