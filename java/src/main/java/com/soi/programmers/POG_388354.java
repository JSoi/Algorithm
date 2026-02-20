package com.soi.programmers;

import java.util.*;

public class POG_388354 {
    public static void main(String[] args) {
        int[] sol = solution(
                new int[]{11, 9, 3, 2, 4, 6},
                new int[][]{{9, 11}, {2, 3}, {6, 3}, {3, 4}});
        int[] sol2 = solution(
                new int[]{9, 15, 14, 7, 6, 1, 2, 4, 5, 11, 8, 10},
                new int[][]{{5, 14}, {1, 4}, {9, 11}, {2, 15}, {2, 5}, {9, 7}, {8, 1}, {6, 4}});

        System.out.println(Arrays.toString(sol));
        System.out.println(Arrays.toString(sol2));
    }

    private static final int FORWARD = 0;
    private static final int REVERSE = 1;
    private static final int NON = -1;
    private static Map<Integer, Set<Integer>> conn;

    public static int[] solution(int[] nodes, int[][] edges) {
        conn = new HashMap<>();
        for (int nn : nodes) {
            conn.put(nn, new HashSet<>());
        }
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            conn.get(from).add(to);
            conn.get(to).add(from);
        }
        HashMap<Integer, Integer> valueToTypeMap = new HashMap<>();
        for (int root : nodes) {
            valueToTypeMap.put(root, getTreeType(root));
        }
//        System.out.println(valueToTypeMap);
        int[] answer = new int[2];
        for (int nn : nodes) {
            int type = valueToTypeMap.get(nn);
            if (type == NON) {
                continue;
            }
            answer[type]++;
        }
        return answer;
    }

    private static int getTreeType(int root) {
        int rootDirection = Math.abs(getDirection(root) - 1);

        HashSet<Integer> visited = new HashSet<>();
        visited.add(root);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int currNode = queue.poll();

            for (int next : conn.get(currNode)) {
                if (visited.contains(next)) {
                    continue;
                }
                if (getDirection(next) != rootDirection) {
                    return NON;
                }
                visited.add(next);
                queue.offer(next);
            }
        }
        return rootDirection;
    }

    private static int getDirection(int startNode) {
        return startNode % 2 != conn.get(startNode).size() % 2 ? FORWARD : REVERSE;
    }
}
