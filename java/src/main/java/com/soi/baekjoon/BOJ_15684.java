package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * <a href = "https://www.acmicpc.net/problem/15684">사다리 조작</a>
 */
public class BOJ_15684 {
    private static int answer = Integer.MAX_VALUE;
    private static boolean[][] ladderStatus;
    private static int n, m, h;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        ladderStatus = new boolean[h][n - 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int row = Integer.parseInt(st.nextToken()) - 1;
            int col = Integer.parseInt(st.nextToken()) - 1;
            ladderStatus[row][col] = true;
        }
        checkLadder(0, -1, 0);
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    private static void checkLadder(int rr, int cc, int extra) {
        if (extra >= answer) return;
        if (extra > 3) return;
        if (doesWin()) {
            answer = extra;
            return;
        }
        for (int r = rr; r < h; r++) {
            for (int c = (r == rr ? cc + 1 : 0); c < n - 1; c++) {
                if (!canPlace(r, c)) continue;
                ladderStatus[r][c] = true;
                checkLadder(r, c, extra + 1);
                ladderStatus[r][c] = false;
            }
        }
    }

    private static boolean doesWin() {
        for (int start = 0; start < n; start++) {
            int currCol = start;
            for (int hh = 0; hh < h; hh++) {
                if (currCol < n - 1 && ladderStatus[hh][currCol]) {
                    currCol++;
                } else if (currCol > 0 && ladderStatus[hh][currCol - 1]) {
                    currCol--;
                }
            }
            if (currCol != start) {
                return false;
            }
        }
        return true;
    }


    private static boolean canPlace(int r, int c) {
        if (ladderStatus[r][c]) return false;
        if (c > 0 && ladderStatus[r][c - 1]) return false;
        if (c < n - 2 && ladderStatus[r][c + 1]) return false;
        return true;
    }
}
