package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class BOJ_17406 {
    private static int[][] board;
    private static int r, c, rotateCount;
    private static final int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static final int UP = 0, DOWN = 1, LEFT = 2, RIGHT = 3;
    private static List<int[]> permutationRes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        rotateCount = Integer.parseInt(st.nextToken());
        board = new int[r][c];
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < c; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        ArrayList<int[]> rotates = new ArrayList<>();
        for (int i = 0; i < rotateCount; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int cR = Integer.parseInt(st.nextToken()) - 1;
            int cC = Integer.parseInt(st.nextToken()) - 1;
            int sp = Integer.parseInt(st.nextToken());
            rotates.add(new int[]{cR, cC, sp});
        }
        permutationRes = new ArrayList<>();
        permutation(0, new int[rotateCount], new boolean[rotateCount]);
        int answer = Integer.MAX_VALUE;
        for (int[] p : permutationRes) {
            // 회전 수행
            int[][] matrix = new int[r][c];
            for (int i = 0; i < r; i++) {
                matrix[i] = Arrays.copyOf(board[i], c);
            }
            for (int pp : p) {
                int[] rotate = rotates.get(pp);
                matrix = rotate(matrix, rotate[0], rotate[1], rotate[2]);
            }
            int[][] finalMatrix = matrix;
            int min = IntStream.range(0, r).map(i -> Arrays.stream(finalMatrix[i]).sum()).min().orElse(0);
            answer = Math.min(answer, min);
        }
        System.out.println(answer);
    }

    private static void permutation(int r, int[] result, boolean[] used) {
        if (r >= rotateCount) {
            permutationRes.add(Arrays.copyOf(result, result.length));
            return;
        }
        for (int i = 0; i < result.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            result[r] = i;
            permutation(r + 1, result, used);
            used[i] = false;
        }
    }

    private static int[][] rotate(int[][] matrix, int centerR, int centerC, int space) {
        int[][] newMatrix = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int d = direction(i, j, centerR, centerC, space);
                if (d == -1) {
                    newMatrix[i][j] = matrix[i][j];
                    continue;
                }
                newMatrix[i][j] = matrix[i + dir[d][0]][j + dir[d][1]];
            }
        }
        return newMatrix;
    }

    private static int direction(int rr, int cc, int centerR, int centerC, int depth) {
        int rDiff = rr - centerR;
        int cDiff = cc - centerC;
        int dist = Math.max(Math.abs(rDiff), Math.abs(cDiff));
        if (dist == 0 || depth < dist) return -1; // do not need to rotate
        if (Math.abs(rDiff) == Math.abs(cDiff)) { // 귀퉁이
            return cornerPosition(rDiff, cDiff);
        }
        return position(rDiff, cDiff, dist);
    }

    private static int cornerPosition(int rDiff, int cDiff) {
        if (rDiff < 0 && cDiff < 0) {
            return DOWN;
        } else if (rDiff < 0 && cDiff > 0) {
            return LEFT;
        } else if (rDiff > 0 && cDiff > 0) {
            return UP;
        } else {
            return RIGHT;
        }
    }

    // 같은 depth
    private static int position(int rDiff, int cDiff, int currentDepth) {
        if (rDiff == -currentDepth) { // 윗부분
            return LEFT;
        } else if (rDiff == currentDepth) { // 아래
            return RIGHT;
        } else if (cDiff == currentDepth) { // 오른쪽
            return UP;
        } else { // 왼쪽
            return DOWN;
        }
    }
}
