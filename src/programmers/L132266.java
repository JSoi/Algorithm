package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class L132266 {
    public static void main(String[] args) {
        new L132266().solution(3, new int[][]{{1, 2}, {2, 3}}, new int[]{2, 3}, 1);
    }

    static int[][] minCost;
    static boolean[] visit;
    final static int MAX = Integer.MAX_VALUE;

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        minCost = new int[n][n];
        for (int[] mc : minCost) {
            Arrays.fill(mc, MAX);
        }
        for (int i = 0; i < n; i++) {
            minCost[i][i] = 0;
        }
        for (int[] r : roads) {
            minCost[r[0] - 1][r[1] - 1] = minCost[r[1] - 1][r[0] - 1] = 1;
        }
        for (int i = 0; i < sources.length; i++) {
            int s = sources[i];
            visit = new boolean[n];
            visit[s - 1] = true;
            search(s - 1, destination - 1);
            answer[i] = minCost[s - 1][destination - 1] == MAX ? -1 : minCost[s - 1][destination - 1];
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }

    private static void search(int start, int end) {
        if (minCost[start][end] != MAX) {
            return;
        }
        Queue<Integer> bfs = new LinkedList<>();
        bfs.offer(start);
        while (!bfs.isEmpty()) {
            int neighbor = bfs.poll();
            minCost[start][end] = Math.min(minCost[start][end], minCost[start][neighbor] + minCost[neighbor][end]);
        }
        visit[start] = true;
    }

}
