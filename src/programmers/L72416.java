package programmers;

import java.util.*;
import java.util.stream.IntStream;

public class L72416 {
    public static void main(String[] args) {
//        int solution = new L72416().solution(new int[]{14, 17, 15, 18, 19, 14, 13, 16, 28, 17}, new int[][]{{10, 8}, {1, 9}, {9, 7}, {5, 4}, {1, 5}, {5, 10}, {10, 6}, {1, 3}, {10, 2}});
        int solution3 = new L72416().solution(new int[]{10, 10, 1, 1}, new int[][]{{3, 2}, {4, 3}, {1, 4}});
//        int solution2 = new L72416().solution(new int[]{5, 6, 5, 3, 4}, new int[][]{{2, 3}, {1, 4}, {2, 5}, {1, 2}});
        System.out.println(solution3);
//        System.out.println(solution2);
    }

    //    static int[] tree;
    static int[] leader;
    static int[] team;
    static int[][] cost;
    static int[] loss;
    static boolean[] visit;

    public static int solution(int[] sales, int[][] links) {
        loss = sales;
        cost = new int[sales.length][2];
        visit = new boolean[sales.length];
        leader = IntStream.range(0, sales.length).map(i -> i == 0 ? 0 : -1).toArray();
        team = new int[sales.length];
        for (int[] link : links) {
            leader[link[0] - 1] = link[0] - 1;
            team[link[1] - 1] = link[0] - 1;
        }
        dfs(0);
        return Math.min(cost[0][0], cost[0][1]);
    }

    private static void dfs(int start) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        visit[start] = true;
        while (!stack.isEmpty()) {
            int current = stack.pop();
            if (leader[current] == -1) { // Leaf node
                cost[current][0] = 0;
                cost[current][1] = loss[current];
                continue;
            }
            int withLeader = loss[current];
            int withoutLeader = 0;
            boolean childParticipate = false;
            int minDiff = Integer.MAX_VALUE;
            for (int i = 0; i < leader.length; i++) {
                if (team[i] == current && !visit[i]) {
                    dfs(i);
                    withLeader += Math.min(cost[i][0], cost[i][1]);
                    withoutLeader += Math.min(cost[i][0], cost[i][1]);
                    if (cost[i][0] >= cost[i][1]) {
                        childParticipate = true;
                    }
                    minDiff = Math.min(minDiff, cost[i][1] - cost[i][0]);
                }
            }
            withoutLeader += childParticipate ? 0 : minDiff;
            cost[current][0] = withoutLeader;
            cost[current][1] = withLeader;
        }
    }
}
