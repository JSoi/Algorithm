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
        findBridge();

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

    private static void findBridge() {
        islandConnection = new int[islandCount + 1][islandCount + 1];
        for (int[] row : islandConnection) Arrays.fill(row, INF);

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 0) continue;

                int from = map[i][j];
                for (int d = 0; d < 4; d++) {
                    int nr = i + dir[d][0];
                    int nc = j + dir[d][1];
                    int len = 0;

                    while (inRange(nr, nc) && map[nr][nc] == 0) {
                        len++;
                        nr += dir[d][0];
                        nc += dir[d][1];
                    }

                    if (!inRange(nr, nc)) continue;
                    if (map[nr][nc] == from) continue;
                    if (len < 2) continue;

                    int to = map[nr][nc];
                    islandConnection[from][to] = Math.min(islandConnection[from][to], len);
                    islandConnection[to][from] = Math.min(islandConnection[to][from], len);
                }
            }
        }

    }

    private static boolean inRange(int rr, int cc) {
        return rr >= 0 && rr < r && cc >= 0 && cc < c;
    }
}
