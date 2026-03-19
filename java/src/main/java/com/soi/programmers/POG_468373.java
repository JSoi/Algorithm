package com.soi.programmers;

import java.util.Arrays;

public class POG_468373 {
    public static void main(String[] args) {
//        int solution = solution(10, 1, new int[][]{{1, 2, 1}, {1, 3, 1}, {1, 4, 3}, {1, 5, 2}, {5, 6, 1}, {5, 7, 1}, {2, 8, 3}, {2, 9, 2}, {9, 10, 1}}, 2);
//        System.out.println("solution = " + solution);

        int solution2 = solution(7, 6, new int[][]{{1, 2, 3}, {1, 4, 3}, {4, 5, 1}, {5, 6, 1}, {3, 6, 2}, {3, 7, 2}}, 3);
        System.out.println("solution2 = " + solution2);
    }

    private static int[][] conn, route;
    private static int answer;
    private static int root, virusCount, manipulateCount;
    private static int[] endCount;

    public static int solution(int n, int infection, int[][] edges, int k) {
        root = infection - 1;
        virusCount = n;
        manipulateCount = k;
        conn = new int[n][n];
        for (int[] ee : edges) {
            int from = ee[0] - 1;
            int to = ee[1] - 1;
            int type = ee[2];
            conn[from][to] = conn[to][from] = type;
        }

        route = new int[n][n];
        for (int[] rr : route) {
            Arrays.fill(rr, -1);
        }

        findRoute(root, 0);
        countEnd();

        for (int t = 1; t <= 3; t++) {
            int[] travelIdxes = new int[virusCount];
            Arrays.fill(travelIdxes, -1);
            open(0, t, travelIdxes);
        }

        return answer;
    }

    private static void open(int depth, int type, int[] pipeIdxes) {
        // check complete
        if (depth == manipulateCount) {
            int completeCount = 0;
            for (int v = 0; v < virusCount; v++) {
                if (v == root || (endCount[v] >= 0 && endCount[v] == pipeIdxes[v])) {
                    completeCount++;
                }
            }
            answer = Math.max(answer, completeCount);
            return;
        }

        for (int nextType = 1; nextType <= 3; nextType++) {
            if (nextType == type) {
                continue;
            }
            int[] nextIdxes = Arrays.copyOf(pipeIdxes, pipeIdxes.length);
            for (int v = 0; v < virusCount; v++) {
                while (route[v][nextIdxes[v] + 1] != -1 && route[v][nextIdxes[v] + 1] == type) {
                    nextIdxes[v]++;
                }
            }
            open(depth + 1, nextType, nextIdxes);
        }
    }

    private static void countEnd() {
        endCount = new int[virusCount];
        for (int v = 0; v < virusCount; v++) {
            for (int vv = 0; vv < virusCount; vv++) {
                if (route[v][vv] == -1) {
                    endCount[v] = vv - 1;
                    break;
                }
            }
        }
    }

    private static void findRoute(int current, int depth) {
        if (depth == virusCount) {
            return;
        }
        for (int v = 0; v < virusCount; v++) {
            int pipeType = conn[current][v];
            if (pipeType == 0 || route[v][depth] != -1) {
                continue;
            }
            for (int i = 0; i < depth; i++) {
                route[v][i] = route[current][i];
            }
            route[v][depth] = pipeType;
            conn[current][v] = conn[v][current] = 0;
            findRoute(v, depth + 1);
        }
    }
}
