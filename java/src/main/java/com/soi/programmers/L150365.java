package com.soi.programmers;

import java.util.*;

public class L150365 {
    public static void main(String[] args) {
        String solution = new L150365().solution(3, 4, 2, 3, 3, 1, 5);
//        String solution = new L150365().solution(2, 2, 1, 1, 2, 2, 2);
//        String solution = new L150365().solution(3, 3, 1, 2, 3, 3, 4);
        System.out.println(solution);

    }

    static final String IMP = "impossible";
    static char[][] map;
    static int moveCount;
    static String answerStr;
    static final int[][] move = new int[][]{{1, 0}, {0, -1}, {0, 1}, {-1, 0}};
    static boolean[][][] visit;
    static final char[] moveChar = new char[]{'d', 'l', 'r', 'u'};

    // d, l, r, u


    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        moveCount = k;
        map = new char[n][m];
        visit = new boolean[n][m][k + 1];
        for (char[] chars : map) {
            Arrays.fill(chars, '.');
        }
        map[x - 1][y - 1] = 'S';
        map[r - 1][c - 1] = 'E';
        travel(x - 1, y - 1, r - 1, c - 1, k);
        return Optional.ofNullable(answerStr).orElse(IMP);

    }

    static void travel(int startR, int startC, int endR, int endC, int totalTravelCount) {
        int currentR = startR;
        int currentC = startC;
        StringBuilder sb = new StringBuilder();
        int travelCount = totalTravelCount;
        while (travelCount > 0) {
            for (int i = 0; i < move.length; i++) {
                int[] m = move[i];
                int nextR = currentR + m[0];
                int nextC = currentC + m[1];
                if (nextR < 0 || nextR >= map.length || nextC < 0 || nextC >= map[0].length ||
                        !isPathLongEnough(nextR, nextC, endR, endC, travelCount)) {
                    continue;
                }
                currentR = nextR;
                currentC = nextC;
                sb.append(moveChar[i]);
                break;
            }
            travelCount--;
        }
        answerStr = currentR == endR && currentC == endC ? sb.toString() : null;
    }

    private static boolean isPathLongEnough(int currentR, int currentC, int destR, int destC, int leftMovements) {
        int btwR = Math.abs(currentR - destR);
        int btwC = Math.abs(currentC - destC);
        return leftMovements >= btwC + btwR;
    }
}
