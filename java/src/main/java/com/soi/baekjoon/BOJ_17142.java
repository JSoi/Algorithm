package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_17142 {
    public static final int MAX = Integer.MAX_VALUE;
    private static int[][] map, finalMap;
    private static int n, virusCount, time;
    private static List<int[]> virusPositions;
    private static List<boolean[]> chosenLists;
    private static final int WALL = MAX;
    private static final int NON_VIRUS = MAX / 2;
    private static boolean[][] visited;
    private static final int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(tok.nextToken());
        virusCount = Integer.parseInt(tok.nextToken());
        virusPositions = new ArrayList<>();
        chosenLists = new ArrayList<>();
        finalMap = new int[n][n];
        for (int i = 0; i < n; i++) {
            tok = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                String val = tok.nextToken();
                finalMap[i][j] = val.equals("1") ? WALL : NON_VIRUS;
                if (val.equals("2")) {
                    virusPositions.add(new int[]{i, j});
                    finalMap[i][j] = 0;
                }
            }
        }
        // virus position combination
        combination(0, 0, new boolean[virusPositions.size()]);
        int answer = MAX;
        for (boolean[] cl : chosenLists) {
            setMap(cl, finalMap);
            visited = new boolean[n][n];
            spread();
            int time = maxTime();
            answer = Math.min(answer, time);
        }
        System.out.println(answer == MAX ? -1 : answer);

    }

    private static void setMap(boolean[] chosen, int[][] finalMap) {
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.copyOf(finalMap[i], finalMap[i].length);
        }
        for (int i = 0; i < chosen.length; i++) {
            int[] pos = virusPositions.get(i);
            map[pos[0]][pos[1]] = chosen[i] ? 0 : NON_VIRUS;
        }
    }

    private static void combination(int idx, int chooseCount, boolean[] choose) {
        if (chooseCount == virusCount) {
            chosenLists.add(Arrays.copyOf(choose, choose.length));
            return;
        }
        for (int i = idx; i < virusPositions.size(); i++) {
            choose[i] = true;
            combination(i + 1, chooseCount + 1, choose);
            choose[i] = false;
        }
    }

    private static int maxTime() {
        int maxTime = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == NON_VIRUS && finalMap[i][j] == NON_VIRUS) {
                    return MAX;
                } else if (map[i][j] < NON_VIRUS && finalMap[i][j] == NON_VIRUS) {
                    maxTime = Math.max(maxTime, map[i][j]);
                }
            }
        }
        return maxTime;
    }

    private static void spread() {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == WALL || map[i][j] == NON_VIRUS) {
                    continue;
                }
                queue.offer(new int[]{i, j, map[i][j]});
            }
        }
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            time = Math.max(time, curr[2]);
            for (int[] d : dir) {
                int x = curr[0] + d[0];
                int y = curr[1] + d[1];
                int dist = curr[2];
                if (x < 0 || x >= n || y < 0 || y >= n || visited[x][y] || map[x][y] != NON_VIRUS) {
                    continue;
                }
                visited[x][y] = true;
                map[x][y] = dist + 1;
                queue.offer(new int[]{x, y, dist + 1});
            }
        }
    }
}
