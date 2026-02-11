package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1600 {
    static final int[][] monkeyMovements = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    static final int[][] horseMovements = new int[][]{{2, 1}, {1, 2}, {-2, 1}, {-1, 2}, {2, -1}, {1, -2}, {-2, -1}, {-1, -2}};
    static final int MAX = Integer.MAX_VALUE;
    static boolean[][] map;
    static int[][][] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        int leftJumpCount = Integer.parseInt(buf.readLine());
        String line = buf.readLine();
        int col = Integer.parseInt(line.split(" ")[0]);
        int row = Integer.parseInt(line.split(" ")[1]);
        map = new boolean[row][col];
        distance = new int[row][col][leftJumpCount + 1];
        for (int[][] dt : distance) {
            for (int[] d : dt) {
                Arrays.fill(d, MAX);
            }
        }
        for (int r = 0; r < row; r++) {
            int[] intArr = Arrays.stream(buf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int c = 0; c < col; c++) {
                map[r][c] = intArr[c] == 0;
            }
        }
        distance[0][0][0] = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0, 0, 0));
        int answer = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            Node latest = queue.poll();
            if (latest.r == row - 1 && latest.c == col - 1) {
                answer = Math.min(answer, latest.movements);
                continue;
            }
            int nR, nC;
            int nextMv = latest.movements + 1;
            int nextJC = latest.leftJump;
            for (int[] mm : monkeyMovements) {
                nR = latest.r + mm[0];
                nC = latest.c + mm[1];
                if (!isInRange(nR, nC, map) || !map[nR][nC] || distance[nR][nC][nextJC] <= nextMv) {
                    continue;
                }
                distance[nR][nC][nextJC] = nextMv;
                queue.offer(new Node(nR, nC, nextMv, nextJC));
            }
            if (nextJC < leftJumpCount) {
                for (int[] hm : horseMovements) {
                    nR = latest.r + hm[0];
                    nC = latest.c + hm[1];
                    if (!isInRange(nR, nC, map) || !map[nR][nC] || distance[nR][nC][nextJC + 1] <= nextMv) {
                        continue;
                    }
                    distance[nR][nC][nextJC + 1] = nextMv;
                    queue.offer(new Node(nR, nC, nextMv, nextJC + 1));
                }
            }
        }
        System.out.println(answer == MAX ? -1 : answer);
    }

    private static boolean isInRange(int r, int c, boolean[][] arr) {
        return r >= 0 && r < arr.length && c >= 0 && c < arr[0].length;
    }

    private static class Node {
        int r;
        int c;
        int movements;
        int leftJump;

        public Node(int r, int c, int movements, int leftJump) {
            this.r = r;
            this.c = c;
            this.movements = movements;
            this.leftJump = leftJump;
        }
    }
}
