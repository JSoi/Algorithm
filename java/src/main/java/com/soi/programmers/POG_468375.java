package com.soi.programmers;

import java.util.*;

public class POG_468375 {
    public static void main(String[] args) {
        int sol1 = solution(3, new String[]{".#.##..", ".#..##.", ".......", "##.###.", ".@.#...", "...#..."},
                new int[][]{{2, 3, 4}, {2, 5, 6}, {1, 1, 1}, {3, 6, 3}},
                new int[][]{{3, 2}, {1, 2}, {4, 1}, {4, 3}});
        System.out.println(sol1 + " = " + 36);
    }

    private static int[][] dist, panels;
    private static int[] toElevator;
    private static Map<Integer, Set<Integer>> conn;
    private static char[][] map;
    private static int r, c, elevR, elevC, panelCount;
    private static int answer = Integer.MAX_VALUE;
    private static boolean[][] prerequisite;
    private static boolean[] preChecked;
    private static final int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static int solution(int h, String[] grid, int[][] p, int[][] seqs) {
        r = grid.length;
        c = grid[0].length();
        panels = p;
        map = new char[r][c];
        panelCount = panels.length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                map[i][j] = grid[i].charAt(j);
                if (map[i][j] == '@') {
                    elevR = i;
                    elevC = j;
                }
            }
        }
        // 거리 정리
        dist = new int[panelCount][panelCount];
        toElevator = new int[panelCount];
        Arrays.fill(toElevator, -1);
        for (int[] dd : dist) {
            Arrays.fill(dd, -1);
        }


        conn = new HashMap<>(); // child -> parents
        for (int[] seq : seqs) {
            int a = seq[0] - 1;
            int b = seq[1] - 1;
            conn.computeIfAbsent(b, k -> new HashSet<>()).add(a);
        }

        prerequisite = new boolean[panelCount][panelCount];
        preChecked = new boolean[panelCount];
        for (int pp = 0; pp < panelCount; pp++) {
            checkPrerequisite(pp);
        }

        // dfs
        dfs(0, 0, new boolean[panelCount], 0);
        return answer;
    }

    private static void checkPrerequisite(int p) {
        if (conn.get(p) == null || preChecked[p]) {
            return;
        }
        preChecked[p] = true;
        for (int pre : conn.get(p)) {
            prerequisite[p][pre] = true;
            checkPrerequisite(pre);
        }
        for (int pre : conn.get(p)) {
            for (int ii = 0; ii < panelCount; ii++) {
                prerequisite[p][ii] |= prerequisite[pre][ii];
            }
        }
    }

    private static void dfs(int currPanel, int depth, boolean[] isProcessed, int distance) {
        if (distance >= answer) return;
        if (depth >= panelCount) {
            answer = distance;
            return;
        }
        for (int i = 0; i < panelCount; i++) {
            if (!fitsCondition(isProcessed, i) || isProcessed[i]) {
                continue;
            }
            isProcessed[i] = true;
            dfs(i, depth + 1, isProcessed, distance + distance(currPanel, i));
            isProcessed[i] = false;
        }
    }

    private static int distance(int fromP, int nextP) {
        if (dist[fromP][nextP] != -1) {
            return dist[fromP][nextP];
        }
        toElevator[fromP] = toElevator[fromP] != -1 ? toElevator[fromP] : distance(elevR, elevC, panels[fromP][1] - 1, panels[fromP][2] - 1);
        toElevator[nextP] = toElevator[nextP] != -1 ? toElevator[nextP] : distance(elevR, elevC, panels[nextP][1] - 1, panels[nextP][2] - 1);
        int distance;
        if (panels[fromP][0] == panels[nextP][0]) {
            distance = distance(panels[fromP][1] - 1, panels[fromP][2] - 1, panels[nextP][1] - 1, panels[nextP][2] - 1);
        } else {
            distance = toElevator[fromP] + toElevator[nextP] + Math.abs(panels[fromP][0] - panels[nextP][0]);
        }
        dist[fromP][nextP] = dist[nextP][fromP] = distance;
        return distance;
    }

    private static boolean fitsCondition(boolean[] isProcessed, int panelIdx) {
        for (int i = 0; i < panelCount; i++) {
            if (!prerequisite[panelIdx][i]) {
                continue;
            }
            if (!isProcessed[i]) {
                return false;
            }
        }
        return true;
    }

    private static int distance(int fromR, int fromC, int toR, int toC) {
        boolean[][] visit = new boolean[r][c];
        Queue<int[]> queue = new ArrayDeque<>();
        visit[fromR][fromC] = true;
        queue.offer(new int[]{fromR, fromC, 0});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == toR && cur[1] == toC) {
                return cur[2];
            }
            for (int[] d : dir) {
                int nextR = cur[0] + d[0];
                int nextC = cur[1] + d[1];
                if (!inRange(nextR, nextC) || visit[nextR][nextC] || map[nextR][nextC] == '#') {
                    continue;
                }
                visit[nextR][nextC] = true;
                queue.offer(new int[]{nextR, nextC, cur[2] + 1});
            }
        }
        return 0;
    }

    private static boolean inRange(int rr, int cc) {
        return rr >= 0 && rr < r && cc >= 0 && cc < c;
    }
}
