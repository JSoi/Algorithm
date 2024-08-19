package programmers;

import java.util.*;
import java.util.stream.IntStream;

public class L72416 {
    public static void main(String[] args) {
//        int solution = new L72416().solution(new int[]{14, 17, 15, 18, 19, 14, 13, 16, 28, 17}, new int[][]{{10, 8}, {1, 9}, {9, 7}, {5, 4}, {1, 5}, {5, 10}, {10, 6}, {1, 3}, {10, 2}});
        int solution2 = new L72416().solution(new int[]{5, 6, 5, 3, 4}, new int[][]{{2, 3}, {1, 4}, {2, 5}, {1, 2}});
//        System.out.println(solution);
        System.out.println(solution2);
    }

    static int[] tree;
    static int[][] cost;
    static int[] loss;
    static Set<Integer> leaders = new HashSet<>();

    public static int solution(int[] sales, int[][] links) {
        loss = sales;
        tree = IntStream.range(0, sales.length).map(i -> -1).toArray();
        cost = IntStream.range(0, sales.length).mapToObj(i -> new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE}).toArray(int[][]::new);
        for (int[] link : links) {
            leaders.add(link[0] - 1);
            tree[link[1] - 1] = link[0] - 1;
        }
        dp(0);
        for (int[] c : cost) {
            System.out.println(Arrays.toString(c));
        }
        return Math.min(cost[0][0], cost[0][1]);
    }

    private static void dp(int start) {
        if (!leaders.contains(start)) {
            cost[start][0] = 0;
            cost[start][1] = loss[start];
            return;
        }

        for (int i = 1; i < tree.length; i++) {
            if (tree[i] == start) {
                dp(i);
            }
        }

        int withLeader = loss[start];
        int withoutLeader = Integer.MAX_VALUE;
        int sum = IntStream.range(1, tree.length).filter(i -> tree[i] == start).map(i -> cost[i][0]).sum();
        int minIndex = 0;
        for (int i = 1; i < tree.length; i++) {
            if (tree[i] == start) {
                withLeader += Math.min(cost[i][0], cost[i][1]);
                withoutLeader = Math.min(withoutLeader, sum - cost[i][0] + cost[i][1]);
            }
        }
        withoutLeader += -cost[minIndex][0] + cost[minIndex][1];
        cost[start][0] = withoutLeader;
        cost[start][1] = withLeader;
    }
}
