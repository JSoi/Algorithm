package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

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
        travel(x - 1, y - 1, k);
        return Optional.ofNullable(answerStr).orElse(IMP);

    }

    static void travel(int startR, int startC, int travelCount) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(startR, startC, ""));
        while (!queue.isEmpty()) {
            Node latest = queue.poll();
            if (latest.track.length() == travelCount && map[latest.r][latest.c] == 'E') {
                answerStr = latest.track;
                return;
            }
            for (int i = 0 ; i < move.length; i++) {
                int[] m = move[i];
                int nextR = latest.r + m[0];
                int nextC = latest.c + m[1];
                if (nextR < 0 || nextR >= map.length || nextC < 0 || nextC >= map[0].length || latest.track.length() >= travelCount) {
                    continue;
                }
                queue.offer(new Node(nextR, nextC, latest.track + moveChar[i]));
            }
        }
    }

    static class Node {
        int r;
        int c;
        String track;

        public Node(int r, int c, String track) {
            this.r = r;
            this.c = c;
            this.track = track;
        }
    }
}
