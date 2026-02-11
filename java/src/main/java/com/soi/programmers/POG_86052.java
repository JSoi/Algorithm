package com.soi.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class POG_86052 {
    private static final int[][] MV = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0},}; // 우, 하, 좌, 상
    private static final int INF = Integer.MAX_VALUE;
    private static int row, col;
    private static int[][][] visited;
    private static char[][] map;

    public static void main(String[] args) {
        solution(new String[]{"SL", "LR"});
        solution(new String[]{"S"});
        solution(new String[]{"R", "R"});
    }

    public static int[] solution(String[] grid) {
        row = grid.length;
        col = grid[0].length();
        map = new char[row][col];
        for (int i = 0; i < grid.length; i++) {
            String s = grid[i];
            map[i] = s.toCharArray();
        }

        ArrayList<Integer> cycles = new ArrayList<>();
        visited = new int[row][col][4];
        for (int[][] vv : visited) {
            for (int[] v : vv) {
                Arrays.fill(v, INF);
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                for (int d = 0; d < 4; d++) {
                    if (visited[i][j][d] != INF) {
                        continue;
                    }
                    int bfs = bfs(i, j, d);
//                    System.out.println(i + " " + j + " " + d + " " + bfs);
                    cycles.add(bfs);
                }
            }
        }
//        System.out.println(cycles);
        return cycles.stream().sorted().mapToInt(x -> x).toArray();
    }

    private static int bfs(int r, int c, int d) {
        Queue<Node> queue = new LinkedList<>();
        visited[r][c][d] = 0;
        queue.add(new Node(r, c, d, 1));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int nextDirIdx = rotate(node.dir, map[node.row][node.col]);
            int nextRow = (node.row + MV[nextDirIdx][0] + row) % row;
            int nextCol = (node.col + MV[nextDirIdx][1] + col) % col;
            if (visited[nextRow][nextCol][nextDirIdx] < node.len + 1) {
                if (nextRow == r && nextCol == c && nextDirIdx == d) {
                    return node.len; // end condition
                }
                continue;
            }
            visited[nextRow][nextCol][nextDirIdx] = node.len + 1;
            queue.add(new Node(nextRow, nextCol, nextDirIdx, node.len + 1));
        }
        return 0;
    }

    public static int rotate(int dirIdx, char grid) {
        return switch (grid) {
            case 'L' -> (dirIdx + 3) % 4;
            case 'R' -> (dirIdx + 1) % 4;
            default -> dirIdx;
        };
    }

    private static class Node {
        int row;
        int col;
        int dir;
        int len;

        public Node(int row, int col, int dir, int len) {
            this.row = row;
            this.col = col;
            this.dir = dir;
            this.len = len;
        }
    }
}
