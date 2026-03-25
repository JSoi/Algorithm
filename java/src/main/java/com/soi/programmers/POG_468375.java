package com.soi.programmers;

import java.util.*;

public class POG_468375 {
    public static void main(String[] args) {
        int sol1 = solution(3, new String[]{".#.##..", ".#..##.", ".......", "##.###.", ".@.#...", "...#..."},
                new int[][]{{2, 3, 4}, {2, 5, 6}, {1, 1, 1}, {3, 6, 3}},
                new int[][]{{3, 2}, {1, 2}, {4, 1}, {4, 3}});
        System.out.println(sol1 + " = " + 36);
    }

    private static int[][] dist;
    private static char[][] map;
    private static int r, c, elevR, elevC, panelCount;
    private static int answer = Integer.MAX_VALUE;
    private static final int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static int solution(int h, String[] grid, int[][] panels, int[][] seqs) {
        r = grid.length;
        c = grid[0].length();
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
        dist = new int[panelCount + 1][panelCount + 1];
        for (int i = 1; i < panelCount + 1; i++) {
            dist[0][i] = dist[i][0] = distance(elevR, elevC, panels[i - 1][1] - 1, panels[i - 1][2] - 1);
        }
        for (int i = 1; i <= panelCount; i++) {
            for (int j = i + 1; j <= panelCount; j++) {
                int distance;
                if (panels[i - 1][0] == panels[j - 1][0]) {
                    distance = distance(panels[i - 1][1] - 1, panels[i - 1][2] - 1, panels[j - 1][1] - 1, panels[j - 1][2] - 1);
                } else {
                    distance = Math.abs(panels[i - 1][0] - panels[j - 1][0]) + dist[i][0] + dist[j][0];
                }
                dist[i][j] = dist[j][i] = distance;
            }
        }

        int[] prerequisitesMask = new int[panelCount + 1];

        int[] inDegrees = new int[panelCount + 1];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] seq : seqs) {
            int pre = seq[0], post = seq[1];
            inDegrees[post]++;
            map.computeIfAbsent(pre, k -> new HashSet<>()).add(post);
        }
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 1; i <= panelCount; i++) {
            if (inDegrees[i] == 0) {
                queue.offer(new int[]{i, 0});
            }
        }
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int curNode = poll[0];
            int curStatus = poll[1];
            prerequisitesMask[curNode] |= curStatus;
            for (int next : map.getOrDefault(curNode, Set.of())) {
                queue.offer(new int[]{next, curStatus | (1 << curNode)});
            }
        }

        int totalMask = 1 << (panelCount + 1);
        int[][] dp = new int[totalMask][panelCount + 1]; // [status][currPanel]
        for (int[] row : dp) Arrays.fill(row, Integer.MAX_VALUE);
        dp[0][1] = 0;

        for (int mask = 0; mask < totalMask; mask++) {
            for (int from = 1; from <= panelCount; from++) {
                if (dp[mask][from] == Integer.MAX_VALUE) continue;
                for (int next = 1; next <= panelCount; next++) {
                    if ((mask & (1 << next)) != 0 || (prerequisitesMask[next] & mask) != prerequisitesMask[next])
                        continue;
                    int nextMask = mask | (1 << next);
                    dp[nextMask][next] = Math.min(dp[nextMask][next], dp[mask][from] + dist[from][next]);
                }
            }
        }

        for (int i = 1; i <= panelCount; i++) {
            answer = Math.min(answer, dp[totalMask - 2][i]);
        }
        return answer;
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
