package com.soi.programmers;

import java.util.*;

public class POG_72416 {
    static int[] team;
    static int[] loss;
    static int[][] cost;
    static Map<Integer, Set<Integer>> teamMap;

    public static void main(String[] args) {
//        int solution = new POG_72416().solution(new int[]{14, 17, 15, 18, 19, 14, 13, 16, 28, 17}, new int[][]{{10, 8}, {1, 9}, {9, 7}, {5, 4}, {1, 5}, {5, 10}, {10, 6}, {1, 3}, {10, 2}});
        int solution3 = solution(new int[]{10, 10, 1, 1}, new int[][]{{3, 2}, {4, 3}, {1, 4}});
//        int solution2 = new POG_72416().solution(new int[]{5, 6, 5, 3, 4}, new int[][]{{2, 3}, {1, 4}, {2, 5}, {1, 2}});
        System.out.println(solution3);
//        System.out.println(solution2);
    }

    public static int solution(int[] sales, int[][] links) {
        loss = sales;
        cost = new int[sales.length][2];
        teamMap = new HashMap<>();
        team = new int[sales.length];
        for (int[] link : links) {
            team[link[1] - 1] = link[0] - 1;
            teamMap.putIfAbsent(link[0] - 1, new HashSet<>());
            teamMap.get(link[0] - 1).add(link[1] - 1);
        }
//        dfs(0);
        dp(0);
        return Math.min(cost[0][0], cost[0][1]);
    }

    private static void dfs(int start) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        while (!stack.isEmpty()) {
            int current = stack.pop();
            if (!teamMap.containsKey(current)) { // Leaf node
                cost[current][0] = 0;
                cost[current][1] = loss[current];
                continue;
            }
            int withLeader = loss[current];
            int withoutLeader = 0;
            boolean childParticipate = false;
            int minDiff = Integer.MAX_VALUE;
            for (int child : teamMap.get(start)) {
                if (team[child] == current) {
                    dfs(child);
                    withLeader += Math.min(cost[child][0], cost[child][1]);
                    withoutLeader += Math.min(cost[child][0], cost[child][1]);
                    if (cost[child][0] >= cost[child][1]) {
                        childParticipate = true;
                    }
                    minDiff = Math.min(minDiff, cost[child][1] - cost[child][0]);
                }
            }
            withoutLeader += childParticipate ? 0 : minDiff;
            cost[current][0] = withoutLeader;
            cost[current][1] = withLeader;
        }
    }

    static void dp(int start) {
        if (!teamMap.containsKey(start)) { // leaf
            cost[start][0] = 0;
            cost[start][1] = loss[start];
            return;
        }
        int sum = 0;
        int minDiff = Integer.MAX_VALUE;
        boolean childParticipate = false;
        for (int child : teamMap.get(start)) {
            dp(child);
            childParticipate |= cost[child][1] <= cost[child][0];
            sum += Math.min(cost[child][0], cost[child][1]);
            minDiff = Math.min(minDiff, cost[child][1] - cost[child][0]);
        }
        int withLeader = loss[start] + sum;
        int withoutLeader = childParticipate ? sum : sum + minDiff;
        cost[start][0] = withoutLeader;
        cost[start][1] = withLeader;
    }
}
