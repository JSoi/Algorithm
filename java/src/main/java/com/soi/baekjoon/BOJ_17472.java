package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_17472 {
    private static final int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public static final int INF = Integer.MAX_VALUE;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[][] islandConnection;
    private static int r, c, answer, islandCount;
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(tok.nextToken());
        c = Integer.parseInt(tok.nextToken());
        map = new int[r][c];
        for (int i = 0; i < r; i++) {
            tok = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(tok.nextToken());
            }
        }
        // find bridge candidates
        visited = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!visited[i][j] && map[i][j] > 0) {
                    islandCount++;
                    findIsland(i, j, islandCount);
                }
            }
        }


        // find bridge
        islandConnection = new int[islandCount + 1][islandCount + 1];
        for (int[] ii : islandConnection) {
            Arrays.fill(ii, INF);
        }
        for (int ii = 1; ii <= islandCount; ii++) {
            findBridge(ii);
        }

//        System.out.println("map");
//        for (int[] mm : map) {
//            System.out.println(Arrays.toString(mm));
//        }
//
//        System.out.println("islandCount: " + islandCount);
//        for (int[] ii : islandConnection) {
//            System.out.println(Arrays.toString(ii));
//        }

        // find minimal cost with islandConnection
        findMinimalCost();

//        System.out.println("parent");
//        System.out.println(Arrays.toString(parent));

        System.out.println(answer);
    }


    private static void findMinimalCost() {
        ArrayList<int[]> edges = new ArrayList<>();
        parent = new int[islandCount + 1];
        for (int i = 1; i <= islandCount; i++) {
            parent[i] = i;
            for (int j = i + 1; j <= islandCount; j++) {
                if (islandConnection[i][j] != INF) {
                    edges.add(new int[]{i, j, islandConnection[i][j]});
                }
            }
        }

        Collections.sort(edges, Comparator.comparingInt(i -> i[2]));
        answer = 0;
        for (int[] e : edges) {
            int from = e[0], to = e[1];
            int cost = e[2];
            if (union(from, to)) {
                answer += cost;
            }
        }

        // check all union
        int firstParent = find(1);
        for (int i = 2; i <= islandCount; i++) {
            if (firstParent != find(i)) {
                answer = -1;
                break;
            }
        }
    }


    private static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot == bRoot) {
            return false;
        }
        parent[bRoot] = aRoot;
        return true;
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    // with bfs
    private static void findIsland(int rr, int cc, int islandType) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{rr, cc});
        visited[rr][cc] = true;
        map[rr][cc] = islandType;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int[] dd : dir) {
                int nR = curr[0] + dd[0];
                int nC = curr[1] + dd[1];
                if (!inRange(nR, nC) || visited[nR][nC] || map[nR][nC] == 0) {
                    continue;
                }
                queue.offer(new int[]{nR, nC});
                visited[nR][nC] = true;
                map[nR][nC] = islandType;
            }
        }
    }

    private static void findBridge(int islandType) {
        boolean[][][] v = new boolean[r][c][4];
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (islandType == map[i][j]) {
                    visited[i][j] = true;
                    for (int d = 0; d < 4; d++) {
                        int nR = i + dir[d][0];
                        int nC = j + dir[d][1];
                        if (!inRange(nR, nC) || v[nR][nC][d] || map[nR][nC] == islandType) {
                            continue;
                        }
                        v[nR][nC][d] = true;
                        queue.offer(new int[]{nR, nC, 1, d});
                    }
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            // reach another island

            if (map[curr[0]][curr[1]] != 0 && map[curr[0]][curr[1]] != islandType) {
                if (curr[2] > 2) {
                    islandConnection[islandType][map[curr[0]][curr[1]]] = Math.min(curr[2] - 1, islandConnection[islandType][map[curr[0]][curr[1]]]);
                    islandConnection[map[curr[0]][curr[1]]][islandType] = Math.min(curr[2] - 1, islandConnection[map[curr[0]][curr[1]]][islandType]);
                }
                continue;
            }
            int cDir = curr[3];
            int nR = curr[0] + dir[cDir][0];
            int nC = curr[1] + dir[cDir][1];
            int cCost = curr[2];
            if (inRange(nR, nC) && !v[nR][nC][cDir] && map[nR][nC] != islandType) {
                v[nR][nC][cDir] = true;
                queue.offer(new int[]{nR, nC, cCost + 1, cDir});
            }
        }

    }

    private static boolean inRange(int rr, int cc) {
        return rr >= 0 && rr < r && cc >= 0 && cc < c;
    }
}
