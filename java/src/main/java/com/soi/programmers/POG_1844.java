package com.soi.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class POG_1844 {
    private static final int[] ds = {0, 0, -1, 1};
    private static final int[] dg = {-1, 1, 0, 0};

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}}));
    }

    public static int solution(int[][] maps) {
        Queue<Node> queue = new LinkedList<>();
        int msero = maps.length;
        int mgaro = maps[0].length;
        int shortest = Integer.MAX_VALUE;
        queue.add(new Node(0, 0, 1));
        while (!queue.isEmpty()) {
            Node target = queue.poll();
            if (target.sero == msero - 1 && target.garo == mgaro - 1) { // 맵 마지막 골인
                shortest = Math.min(shortest, target.pathCount);
            }
            for (int i = 0; i < 4; i++) {
                int nsero = target.sero + ds[i];
                int ngaro = target.garo + dg[i];
                if (nsero < 0 || nsero >= msero || ngaro < 0 || ngaro >= mgaro || maps[nsero][ngaro] != 1) {
                    continue;
                }
                maps[nsero][ngaro] = 0;
                queue.add(new Node(nsero, ngaro, target.pathCount + 1));
            }
        }
        return shortest == Integer.MAX_VALUE ? -1 : shortest;
    }

    private static class Node {
        int sero;
        int garo;
        int pathCount;

        public Node(int sero, int garo, int pathCount) {
            this.sero = sero;
            this.garo = garo;
            this.pathCount = pathCount;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "sero=" + sero +
                    ", garo=" + garo +
                    ", pathCount=" + pathCount +
                    '}';
        }
    }
}
