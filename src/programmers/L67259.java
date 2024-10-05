package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class L67259 {
    public static void main(String[] args) {
//        int solution = new L67259().solution(new int[][]{{0, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0, 1}, {0, 0, 1, 0, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 1, 0, 0}, {1, 0, 0, 0, 0, 0, 0, 0}});
        int solution = new L67259().solution(
                new int[][]{
                        {0, 0, 0, 0, 0},
                        {0, 1, 1, 1, 0},
                        {0, 0, 1, 0, 0},
                        {1, 0, 0, 0, 1},
                        {1, 1, 1, 0, 0}});
        System.out.println("solution = " + solution);
    }

    final int[][] directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        int[][] cost = new int[board.length][board[0].length];
        boolean[][][] visitedWithDirection = new boolean[board.length][board[0].length][4];
        for (int[] c : cost) {
            Arrays.fill(c, Integer.MAX_VALUE);
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
                        (visitedWithDirection[nextR][nextC][i] && cost[nextR][nextC] < nextCost)) {
                    continue;
                }
                visitedWithDirection[nextR][nextC][i] = true;
                cost[nextR][nextC] = Math.min(nextCost, cost[nextR][nextC]);
                queue.offer(new Node(nextR, nextC, nextCost, i, nextCount));
            }
        }
        return answer;
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
