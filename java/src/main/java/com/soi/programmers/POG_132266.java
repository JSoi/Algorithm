package com.soi.programmers;

import java.util.*;

public class POG_132266 {
    static final int MAX = Integer.MAX_VALUE;
    static int[] minCost;
    static boolean[] visit;
    static Map<Integer, Set<Integer>> map;

    public static void main(String[] args) {
        new POG_132266().solution(3, new int[][]{{1, 2}, {2, 3}}, new int[]{2, 3}, 1);
//        new POG_132266().solution(5, new int[][]{{1, 2}, {1, 4}, {2, 4,}, {2, 5}, {4, 5}}, new int[]{1, 3, 5}, 5);
    }

    private static void visit(int end) {
        Queue<Node> bfs = new LinkedList<>();
        minCost[end] = 0;
        visit[end] = true;
        bfs.offer(new Node(end, 0)); // start로 잡자
        while (!bfs.isEmpty()) {
            Node neighbor = bfs.poll();
            for (int n : map.get(neighbor.index)) {
                if (visit[n] || minCost[n] < neighbor.cost + 1) {
                    continue;
                }
                visit[n] = true;
                minCost[n] = neighbor.cost + 1;
                bfs.offer(new Node(n, neighbor.cost + 1));
            }
        }
    }

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        minCost = new int[n];
        Arrays.fill(minCost, MAX);
        map = new HashMap<>();
        visit = new boolean[n];
        for (int[] r : roads) {
            map.computeIfAbsent(r[0] - 1, k -> new HashSet<>()).add(r[1] - 1);
            map.computeIfAbsent(r[1] - 1, k -> new HashSet<>()).add(r[0] - 1);
        }
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(i)) {
                visit[i] = true; // 조사 대상에서 제외
            }
        }
        visit(destination - 1);
        for (int a = 0; a < sources.length; a++) {
            answer[a] = minCost[sources[a] - 1] == MAX ? -1 : minCost[sources[a] - 1];
        }
//        System.out.println(Arrays.toString(answer));
        return answer;
    }

    private static class Node {
        int index;
        int cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
    }

}
