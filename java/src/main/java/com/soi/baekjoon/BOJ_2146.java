package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2146 {
    private static final int[][] movements = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static boolean[][] visitedIsland;
    private static int n;
    private static boolean[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new boolean[n][n];
        visitedIsland = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                map[i][j] = tok.nextToken().equals("1");
            }
        }
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j]) {
                    Set<int[]> islands = findIslandElement(i, j);
                    answer = Math.min(answer, findShortestPath(islands));
                }
            }
        }
        System.out.println(answer);
    }

    private static Set<int[]> findIslandElement(int startR, int startC) {
        Set<int[]> result = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        result.add(new int[]{startR, startC});
        queue.add(new int[]{startR, startC});
        visitedIsland[startR][startC] = true;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currR = curr[0];
            int currC = curr[1];
            for (int[] m : movements) {
                int nextR = currR + m[0];
                int nextC = currC + m[1];
                if (!inRange(nextR, nextC) || visitedIsland[nextR][nextC] || !map[nextR][nextC]) {
                    continue;
                }
                visitedIsland[nextR][nextC] = true;
                result.add(new int[]{nextR, nextC});
                queue.offer(new int[]{nextR, nextC});
            }
        }
        return result;
    }

    private static int findShortestPath(Set<int[]> islands) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] v = new boolean[n][n];
        for (int[] ii : islands) {
            v[ii[0]][ii[1]] = true;
            queue.offer(new int[]{ii[0], ii[1], 0});
        }
        int answer = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currR = curr[0];
            int currC = curr[1];
            int currD = curr[2];
            if (map[currR][currC] && !visitedIsland[currR][currC]) { // reach other islands
                answer = Math.min(answer, currD - 1);
            }
            for (int[] m : movements) {
                int nextR = currR + m[0];
                int nextC = currC + m[1];
                int nextD = currD + 1;
                if (!inRange(nextR, nextC) || v[nextR][nextC]) {
                    continue;
                }
                v[nextR][nextC] = true;
                queue.offer(new int[]{nextR, nextC, nextD});
            }
        }
        return answer;
    }

    private static boolean inRange(int nR, int nC) {
        return nR >= 0 && nR < n && nC >= 0 && nC < n;
    }
}
