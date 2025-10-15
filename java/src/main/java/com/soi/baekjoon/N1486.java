package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N1486 {
    private static int r, c;
    private static int timeLimit, maxDiff;
    private static int[][] map;
    private static final int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static final int INF = Integer.MAX_VALUE;
    private static List<int[]>[] graph;
    private static List<int[]>[] reverseGraph;

    public static void main(String[] args) throws IOException {
        input();
        int[] forward = dijkstra(graph);
        int[] back = dijkstra(reverseGraph);
//        System.out.println(Arrays.toString(forward));
//        System.out.println(Arrays.toString(back));
        int maxHeight = 0;
        for (int i = 0; i < r * c; i++) {
            if (forward[i] != INF && back[i] != INF && forward[i] + back[i] <= timeLimit) {
                maxHeight = Math.max(maxHeight, map[i / c][i % c]);
            }
        }
        System.out.println(maxHeight);
    }

    private static int[] dijkstra(List<int[]>[] graph) {
        int[] dist = new int[r * c];
        Arrays.fill(dist, INF);
        dist[0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{0, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int cost = cur[1];
            if (cost > dist[cur[0]]) continue;
            for (int[] next : graph[cur[0]]) {
                int nextNode = next[0];
                int nextCost = cost + next[1];
                if (nextCost < dist[nextNode]) {
                    dist[nextNode] = nextCost;
                    pq.offer(new int[]{nextNode, nextCost});
                }
            }
        }
        return dist;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(tok.nextToken());
        c = Integer.parseInt(tok.nextToken());
        maxDiff = Integer.parseInt(tok.nextToken());
        timeLimit = Integer.parseInt(tok.nextToken());
        map = new int[r][c];
        graph = new ArrayList[r * c];
        reverseGraph = new ArrayList[r * c];
        for (int i = 0; i < r * c; i++) {
            graph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }
        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                int h = toNum(line.charAt(j));
                map[i][j] = h;
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int from = i * c + j;
                for (int[] d : dir) {
                    int ni = i + d[0];
                    int nj = j + d[1];
                    if (!inRange(ni, nj) || Math.abs(map[i][j] - map[ni][nj]) > maxDiff) continue;
                    int to = ni * c + nj;
                    int cost = cost(map[i][j], map[ni][nj]);
                    graph[from].add(new int[]{to, cost});
                    reverseGraph[to].add(new int[]{from, cost});
                }
            }
        }
//        System.out.println(Arrays.deepToString(map));
    }

    private static boolean inRange(int rr, int cc) {
        return rr >= 0 && rr < r && cc >= 0 && cc < c;
    }

    private static int cost(int fromH, int toH) {
        if (fromH >= toH) return 1;
        int diff = toH - fromH;
        return diff * diff;
    }

    private static int toNum(char c) {
        if (c >= 'A' && c <= 'Z') {
            return c - 'A';
        }
        return c - 'a' + 26;
    }
}
