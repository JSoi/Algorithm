package com.soi.programmers;

public class L1832 {

    public static void main(String[] args) {
        int solution = new L1832().solution(3, 6, new int[][]{{0, 2, 0, 0, 0, 2}, {0, 0, 2, 0, 1, 0}, {1, 0, 0, 2, 2, 0}});
//        int solution = new L1832().solution(3, 3, new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}});
    }

    public static final int UP = 0;

    public static final int RIGHT = 1;


    int MOD = 20170805;

    public int solution(int m, int n, int[][] cityMap) {
        int[][][] answerMap = new int[cityMap.length + 1][cityMap[0].length + 1][2];
        // up : 0, right : 1
        answerMap[1][1][0] = answerMap[1][1][1] = 1;
        for (int r = 0; r < cityMap.length; r++) {
            for (int c = 0; c < cityMap[0].length; c++) {
                int nextR = r + 1;
                int nextC = c + 1;
                if (cityMap[r][c] == 1) { // 통과 불가능
                    answerMap[nextR][nextC][UP] = answerMap[nextR][nextC][RIGHT] = UP;
                } else if (cityMap[r][c] == 0) { // 모두 통과 가능
                    answerMap[nextR][nextC][UP] += answerMap[nextR][c][UP] + answerMap[r][nextC][RIGHT];
                    answerMap[nextR][nextC][RIGHT] += answerMap[nextR][c][UP] + answerMap[r][nextC][RIGHT];
                } else { // 위-> 아래, 좌-> 우만 통과 가능
                    answerMap[nextR][nextC][UP] += answerMap[nextR][c][UP];
                    answerMap[nextR][nextC][RIGHT] += answerMap[r][nextC][RIGHT];
                }
                answerMap[nextR][nextC][UP] %= MOD;
                answerMap[nextR][nextC][RIGHT] %= MOD;
            }
        }
        return (answerMap[m-1][n][RIGHT] + answerMap[m][n-1][UP]) % MOD;
    }
}
