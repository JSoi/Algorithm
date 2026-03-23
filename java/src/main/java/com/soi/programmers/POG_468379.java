package com.soi.programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class POG_468379 {
    public static void main(String[] args) {
        POG_468379 sol = new POG_468379();
        int[] s1 = sol.solution(4, 5, 2, 2, new int[][]{{0, 0}, {3, 1}, {1, 3}, {2, 4}, {1, 1}, {2, 2}, {2, 3}, {0, 4}});
        System.out.println(Arrays.toString(s1));
        System.out.println("answer = [2, 2]");
    }

    private static final int INF = Integer.MAX_VALUE;

    public int[] solution(int r, int c, int h, int w, int[][] drops) {
        int[][] dp = new int[r][c];
        int[][] map = new int[r][c];
        for (int rr = 0; rr < r; rr++) {
            Arrays.fill(map[rr], INF);
            Arrays.fill(dp[rr], INF);
        }

        for (int d = 0; d < drops.length; d++) {
            int[] drop = drops[d];
            map[drop[0]][drop[1]] = d + 1;
        }

        for (int i = 0; i < r; i++) {
            PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(q -> q[0])); // { dropIdx, col }
            for (int jj = 0; jj < w - 1; jj++) {
                queue.offer(new int[]{map[i][jj], jj});
            }
            for (int j = 0; j + w - 1 < c; j++) {
                queue.offer(new int[]{map[i][j + w - 1], j + w - 1});
                while (!queue.isEmpty() && queue.peek()[1] < j) {
                    queue.poll();
                }
                if (!queue.isEmpty()) {
                    dp[i][j] = queue.peek()[0];
                }
            }
        }

        for (int j = 0; j + w - 1 < c; j++) {
            PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(q -> q[0])); // { dropIdx, row }
            for (int ii = 0; ii < h - 1; ii++) {
                queue.offer(new int[]{dp[ii][j], ii});
            }
            for (int i = 0; i + h - 1 < r; i++) {
                queue.offer(new int[]{dp[i + h - 1][j], i + h - 1});
                while (!queue.isEmpty() && queue.peek()[1] < i) {
                    queue.poll();
                }
                if (!queue.isEmpty()) {
                    dp[i][j] = queue.peek()[0];
                }
            }
        }

        int maxDropIdx = 0;
        int[] answer = new int[2];
        for (int i = 0; i + h - 1 < r; i++) {
            for (int j = 0; j + w - 1 < c; j++) {
                if (dp[i][j] == INF) {
                    return new int[]{i, j};
                }
                if (maxDropIdx < dp[i][j]) {
                    maxDropIdx = dp[i][j];
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }
        return answer;
    }

}
