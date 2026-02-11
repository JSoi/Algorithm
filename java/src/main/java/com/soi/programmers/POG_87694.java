package com.soi.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class POG_87694 {

    private static final int MAX = 50;
    private static final int[][] mv = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) {
        int solution = solution(new int[][]{{1, 1, 7, 4}, {3, 2, 5, 5}, {4, 3, 6, 9}, {2, 6, 8, 8}}, 1, 3, 7, 8);
        System.out.println(solution);

    }

    public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        boolean[][] map = new boolean[MAX + 1][MAX + 1];
        boolean[][] visited = new boolean[MAX + 1][MAX + 1];

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{characterX, characterY, 0});
        visited[characterX][characterY] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == itemX && cur[1] == itemY) {
                return cur[2];
            }
            for (int[] m : mv) {
                int x = cur[0] + m[0];
                int y = cur[1] + m[1];
                if (!isInRange(x, y) ||
                        visited[x][y] ||
                        isOutsideRectangle(cur[0], cur[1], x, y, rectangle)) {
                    continue;
                }

                boolean onBorder = isOnBorder(cur[0], cur[1], x, y, rectangle);
                map[x][y] = onBorder;
                if (!onBorder) continue;

                visited[x][y] = true;
                queue.offer(new int[]{x, y, cur[2] + 1});
            }
        }
        return 0;
    }

    private static boolean isOnBorder(int r1, int c1, int r2, int c2, int[][] rectangle) {
        boolean isOnBorder = false;
        for (int[] rec : rectangle) {
            if (insideRectangle(r1, c1, r2, c2, rec)) return false;
            if (r1 == r2 && Math.min(c1, c2) >= rec[1] && Math.max(c1, c2) <= rec[3]) {
                if (r1 > Math.min(rec[0], rec[2]) && r1 < Math.max(rec[0], rec[2])) {
                    return false;
                }
                if (r1 == rec[0] || r1 == rec[2]) {
                    isOnBorder = true;
                }

            } else if (c1 == c2 && Math.min(r1, r2) >= rec[0] && Math.max(r1, r2) <= rec[2]) {
                if (c1 > Math.min(rec[1], rec[3]) && c1 < Math.max(rec[1], rec[3])) {
                    return false;
                }
                if (c1 == rec[1] || c1 == rec[3]) {
                    isOnBorder = true;
                }

            }
        }
        return isOnBorder;
    }

    private static boolean insideRectangle(int r1, int c1, int r2, int c2, int[] rec) {
        if (rec[0] < r1 && r1 < rec[2] && rec[1] < c1 && c1 < rec[3]) {
            return true;
        }
        return rec[0] < r2 && r2 < rec[2] && rec[1] < c2 && c2 < rec[3];
    }

    private static boolean isOutsideRectangle(int r1, int c1, int r2, int c2, int[][] rectangle) {
        for (int[] rec : rectangle) {
            if (rec[0] <= Math.min(r1, r2) && rec[2] >= Math.max(r1, r2) && rec[1] <= Math.min(c1, c2) && rec[3] >= Math.max(c1, c2)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isInRange(int r, int c) {
        return r >= 1 && r <= MAX && c >= 1 && c <= MAX;
    }
}
