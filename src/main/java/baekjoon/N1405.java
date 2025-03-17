package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * <a href = "https://www.acmicpc.net/problem/1405">미친로봇</a>
 */
public class N1405 {
    private static double[] moveOdds;
    private static final int[][] movements = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static int moveCount;
    private static double answer = 0.0;
    private static boolean[][] visit;
    private static final int OFFSET = 15;
    private static final int MAX_SIZE = 2 * OFFSET + 1;

    public static void main(String[] args) throws IOException {
        StringTokenizer tok = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine(), " ");
        moveCount = Integer.parseInt(tok.nextToken());
        moveOdds = new double[4];
        for (int i = 0; i < 4; i++) {
            moveOdds[i] = Double.parseDouble(tok.nextToken()) / 100;
        }
        visit = new boolean[MAX_SIZE][MAX_SIZE];
        visit[OFFSET][OFFSET] = true;
        answer = 0.0;
        travel(0, OFFSET, OFFSET, 1);
        System.out.println(answer);
    }

    private static void travel(int move, int r, int c, double odd) {
        if (move == moveCount) {
            answer += odd;
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (moveOdds[i] == 0) continue;
            int[] m = movements[i];
            double nextOdd = odd * moveOdds[i];
            int nextR = m[0] + r;
            int nextC = m[1] + c;
            if (visit[nextR][nextC]) {
                continue;
            }
            visit[nextR][nextC] = true;
            travel(move + 1, nextR, nextC, nextOdd);
            visit[nextR][nextC] = false;
        }
    }
}
