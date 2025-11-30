package com.soi.programmers;

import java.util.*;

public class L118669 {
    public static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[] solution = new L118669().solution(6, new int[][]{{1, 2, 3}, {2, 3, 5}, {2, 4, 2}, {2, 5, 4}, {3, 4, 4}, {4, 5, 3}, {4, 6, 1}, {5, 6, 1}}, new int[]{1, 3}, new int[]{5});
        System.out.println(Arrays.toString(solution));
    }

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] intensity = new int[n + 1];
        List<int[]>[] conn = new List[n + 1];

        boolean[] isSummit = new boolean[n + 1];
        for (int s : summits) isSummit[s] = true;

        for (int i = 0; i <= n; i++) {
            conn[i] = new ArrayList<>();
        }

        Arrays.fill(intensity, INF);

        for (int[] path : paths) {
            conn[path[0]].add(new int[]{path[1], path[2]});
            conn[path[1]].add(new int[]{path[0], path[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        for (int gate : gates) {
            pq.offer(new int[]{gate, 0});
            intensity[gate] = 0;
        }

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0], cost = current[1];
            if (intensity[current[0]] < current[1] || isSummit[current[0]]) {
                continue;
            }
            for (int[] nxt : conn[node]) {
                int nextNode = nxt[0];
                int edgeCost = nxt[1];

                int nextIntensity = Math.max(cost, edgeCost);

                if (nextIntensity < intensity[nextNode]) {
                    intensity[nextNode] = nextIntensity;
                    pq.offer(new int[]{nextNode, nextIntensity});
                }
            }
        }

        int min = INF;
        int minSummit = 0;
        Arrays.sort(summits);

        for (int summit : summits) {
            if (min > intensity[summit]) {
                minSummit = summit;
                min = intensity[summit];
            }
        }
        return new int[]{minSummit, min};
    }

}
