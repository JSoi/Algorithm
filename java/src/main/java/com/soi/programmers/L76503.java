package com.soi.programmers;

import java.util.ArrayList;
import java.util.List;

public class L76503 {
    private static boolean[] visit;
    private static long[] nodes;
    private static int n;
    private static long answer;
    private static List<Integer>[] conn;

    public static long solution(int[] a, int[][] edges) {
        n = a.length;
        nodes = new long[n];
        conn = new List[n];
        visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            conn[i] = new ArrayList<>();
            nodes[i] = a[i];
        }
        for (int[] e : edges) {
            conn[e[0]].add(e[1]);
            conn[e[1]].add(e[0]);
        }
        long sum = 0;
        for (long nn : nodes) {
            sum += nn;
        }
        if (sum != 0) return -1;
        visit[0] = true;
        dfs(0);
        return answer;
    }

    private static void dfs(int parent) {
        for (int i = 0; i < conn[parent].size(); i++) {
            int next = conn[parent].get(i);
            if (visit[next]) {
                continue;
            }
            visit[next] = true;
            dfs(next);
            answer += Math.abs(nodes[next]);
            nodes[parent] += nodes[next];
        }
    }

    public static void main(String[] args) {
        solution(new int[]{-5, 0, 2, 1, 2}, new int[][]{{0, 1}, {3, 4}, {2, 3}, {0, 3}});
//        solution(new int[]{0,1,0}, new int[][]{{0, 1}, {1,2}});
    }
}
