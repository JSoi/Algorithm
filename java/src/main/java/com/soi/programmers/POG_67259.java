package com.soi.programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class POG_67259 {


    public static final int MAX = Integer.MAX_VALUE - 1000;
    final int[][] directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) {
//        int solution = new POG_67259().solution(new int[][]{{0, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0, 1}, {0, 0, 1, 0, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 1, 0, 0}, {1, 0, 0, 0, 0, 0, 0, 0}});
        int solution = new POG_67259().solution(
                new int[][]{
                        {0, 0, 0, 0, 0},
                        {0, 1, 1, 1, 0},
                        {0, 0, 1, 0, 0},
                        {1, 0, 0, 0, 1},
                        {1, 1, 1, 0, 0}}); // 3100
        System.out.println("solution = " + solution);
    }

    public int solution(int[][] board) {
        int answer = MAX;
        int len = board.length;
        int[][][] cost = new int[len][len][5]; // index 4 = total
        for (int[][] c : cost) {
            for (int[] cc : c) {
                Arrays.fill(cc, MAX);
            }
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0, 0, -1, 0));
        while (!queue.isEmpty()) {
            Node latest = queue.poll();
            if (latest.r == board.length - 1 && latest.c == board[0].length - 1) {
                answer = Math.min(answer, latest.cost);
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int[] d = directions[i];
                int nextR = latest.r + d[0];
                int nextC = latest.c + d[1];
                int nextCount = latest.count + 1;
                int nextCost = latest.cost + ((latest.latestDirection == i || latest.latestDirection == -1) ? 100 : 600);
                if (!isInBoundary(board, nextR, nextC) || board[nextR][nextC] == 1 ||
                        cost[nextR][nextC][i] < nextCost || cost[nextR][nextC][4] + 500 < nextCost) {
                    continue;
                }
                cost[nextR][nextC][i] = Math.min(nextCost, cost[nextR][nextC][i]);
                cost[nextR][nextC][4] = Math.min(cost[nextR][nextC][4], nextCost);
                queue.offer(new Node(nextR, nextC, nextCost, i, nextCount));
            }
        }
        return cost[len - 1][len - 1][4];
    }

    private boolean isInBoundary(int[][] arr, int r, int c) {
        return r >= 0 && r < arr.length && c >= 0 && c < arr[0].length;
    }

    private static class Node {
        int r;
        int c;
        int cost;
        int latestDirection;
        int count;

        public Node(int r, int c, int cost, int latestDirection, int count) {
            this.r = r;
            this.c = c;
            this.cost = cost;
            this.latestDirection = latestDirection;
            this.count = count;
        }
    }
}
