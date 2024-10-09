package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class L121690 {

    public static void main(String[] args) {
        int solution = new L121690().solution(4, 4, new int[][]{{4, 1}});
        System.out.println("solution = " + solution);
    }


    public static final int MAX = Integer.MAX_VALUE;
    static final int[][] walkDirections = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    static final int[][] jumpDirections = new int[][]{{-2, 0}, {2, 0}, {0, 2}, {0, -2}};
    static int[][][] cost;
    static boolean[][] map;

    public int solution(int n, int m, int[][] hole) {
        // n : width, m : height
        cost = new int[m][n][2];
        map = new boolean[m][n];
        for (boolean[] bArr : map) {
            Arrays.fill(bArr, true);
        }
        for (int[][] ct : cost) {
            for (int[] c : ct) {
                Arrays.fill(c, MAX);
            }
        }
        for (int[] h : hole) {
            map[m - h[1]][h[0] - 1] = false;
        }
        cost[m - 1][0][0] = cost[m - 1][0][1] = 0;
        findPath(m - 1, 0);
        int val = Math.min(cost[0][n - 1][0], cost[0][n - 1][1]);
        return val == MAX ? -1 : val;
    }

    private static void findPath(int r, int c) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(r, c, 0, 1));
        while (!queue.isEmpty()) {
            Node latest = queue.poll();
            if (latest.r == 0 && latest.c == map[0].length - 1) {
                continue;
            }
            int nCost = latest.cost + 1;
            int jCount = latest.leftJumpCount;
            int nR, nC;
            for (int[] d : walkDirections) {
                nR = latest.r + d[0];
                nC = latest.c + d[1];
                if (!isInRange(nR, nC) || !map[nR][nC] || cost[nR][nC][jCount] <= nCost) {
                    continue;
                }
                cost[nR][nC][jCount] = nCost;
                queue.offer(new Node(nR, nC, nCost, jCount));
            }
            if (jCount == 1) { // able to jump
                for (int[] d : jumpDirections) {
                    nR = latest.r + d[0];
                    nC = latest.c + d[1];
                    if (!isInRange(nR, nC) || !map[nR][nC] || cost[nR][nC][0] <= nCost) {
                        continue;
                    }
                    cost[nR][nC][0] = nCost;
                    queue.offer(new Node(nR, nC, nCost, 0));
                }
            }

        }
    }

    private static boolean isInRange(int r, int c) {
        return r >= 0 && r < map.length && c >= 0 && c < map[0].length;
    }

    private static class Node {
        int r;
        int c;
        int cost;
        int leftJumpCount;


        public Node(int r, int c, int cost, int leftJumpCount) {
            this.r = r;
            this.c = c;
            this.cost = cost;
            this.leftJumpCount = leftJumpCount;
        }
    }
}
