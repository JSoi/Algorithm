package com.soi.programmers;

import com.soi.tool.Assertions;

import java.util.LinkedList;
import java.util.Queue;

public class L1844_2 {
    public static void main(String[] args) throws Exception {
        int solution = new L1844_2().solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}});
        int solution2 = new L1844_2().solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 0}, {0, 0, 0, 0, 1}});
        Assertions.check(solution, 11);
        Assertions.check(solution2, -1);
    }

    public int solution(int[][] maps) {
        int answer = -1;
        final int[][] movement = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        boolean[][] visit = new boolean[maps.length][maps[0].length];
        Queue<Node> bfs = new LinkedList<>();
        visit[0][0] = true;
        bfs.offer(new Node(0, 0, 1));
        while (!bfs.isEmpty()) {
            Node visitNode = bfs.poll();
            if (visitNode.row == maps.length - 1 && visitNode.col == maps[0].length - 1) {
                answer = answer == -1 ? visitNode.dist : Math.min(answer, visitNode.dist);
                continue;
            }
            for (int[] mv : movement) {
                int nextRow = visitNode.row + mv[0];
                int nextCol = visitNode.col + mv[1];
                if (nextCol < 0 || nextCol >= maps[0].length || nextRow < 0 || nextRow >= maps.length
                        || maps[nextRow][nextCol] == 0 || visit[nextRow][nextCol])
                    continue;
                visit[nextRow][nextCol] = true;
                bfs.offer(new Node(nextRow, nextCol, visitNode.dist + 1));
            }
        }
        return answer;
    }

    static class Node {
        int row, col, dist;

        public Node(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }
}
