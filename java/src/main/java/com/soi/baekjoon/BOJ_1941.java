package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class BOJ_1941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            sb.append(br.readLine());
        }
        map = sb.toString().toCharArray();
        combination(0, 0, 0, 0, new int[7]);
        System.out.println(answer);
    }

    private static char[] map;
    private static int answer;
    private static final int[][] move = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private static void combination(int idx, int r, int s, int y, int[] result) {
        if (y >= 4) {
            return;
        }
        if (r >= 7) {
            if (isAdjacent(result)) answer++;
            return;
        }
        for (int i = idx; i < 25; i++) {
            char c = map[i];
            boolean isS = c == 'S';
            int nextS = isS ? s + 1 : s;
            int nextY = !isS ? y + 1 : y;
            result[r] = i;
            combination(i + 1, r + 1, nextS, nextY, result);
        }
    }

    private static boolean isAdjacent(int[] result) {
        boolean[] visit = new boolean[25];
        boolean[] isCandidate = new boolean[25];
        for (int rr : result) {
            isCandidate[rr] = true;
        }
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        visit[result[0]] = true;
        queue.offer(result[0]);
        int satifiedCount = 0;
        while (!queue.isEmpty()) {
            int next = queue.poll();
            if (isCandidate[next]) {
                satifiedCount++;
            } else {
                continue;
            }
            int toR = next / 5;
            int toC = next % 5;
            for (int[] m : move) {
                int nR = toR + m[0];
                int nC = toC + m[1];
                int flattenPos = nR * 5 + nC;
                if (nR < 0 || nC < 0 || nR >= 5 || nC >= 5 || visit[flattenPos]) {
                    continue;
                }
                visit[flattenPos] = true;
                queue.offer(flattenPos);
            }
        }
        return satifiedCount == 7;
    }
}
