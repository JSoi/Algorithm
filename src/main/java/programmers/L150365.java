package programmers;

import java.util.Arrays;
import java.util.Optional;

public class L150365 {
    static final String IMP = "impossible";
    static char[][] map;
    static int moveCount;
    static String answerStr;
    static final int[][] move = new int[][]{{1, 0}, {0, -1}, {0, 1}, {-1, 0}};
    static final char[] moveChar = new char[]{'d', 'l', 'r', 'u'};

    // d, l, r, u
    public static void main(String[] args) {
        String solution = new L150365().solution(3, 4, 2, 3, 3, 1, 5);
//        String solution = new L150365().solution(2, 2, 1, 1, 2, 2, 2);
//        String solution = new L150365().solution(3, 3, 1, 2, 3, 3, 4);
        System.out.println(solution);

    }

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        moveCount = k;
        map = new char[n][m];
        for (char[] chars : map) {
            Arrays.fill(chars, '.');
        }
        map[x - 1][y - 1] = 'S';
        map[r - 1][c - 1] = 'E';
        travel(x - 1, y - 1, 0, "");
        return Optional.ofNullable(answerStr).orElse(IMP);

    }

    static void travel(int currentR, int currentC, int travelCount, String track) {
        if (answerStr != null) {
            return;
        }
        if (travelCount == moveCount) {
            if (map[currentR][currentC] == 'E') {
                answerStr = track;
            }
            return;
        }
        for (int i = 0; i < move.length; i++) {
            int nextR = currentR + move[i][0];
            int nextC = currentC + move[i][1];
            if (nextR < 0 || nextR >= map.length || nextC < 0 || nextC >= map[0].length) {
                continue;
            }
            travel(nextR, nextC, travelCount + 1, track + moveChar[i]);
        }
    }
}
