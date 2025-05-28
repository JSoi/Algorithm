package com.soi.programmers;

import java.util.*;

public class L169199 {
    private static final int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static int solution(String[] board) {
        int startX = 0, startY = 0, endX = 0, endY = 0;
        boolean[][] visited = new boolean[board.length][board[0].length()];
        boolean[][] map = new boolean[board.length][board[0].length()];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length(); j++) {
                char now = board[i].charAt(j);
                if (now == 'D') {
                    continue;
                }
                map[i][j] = true;
                if (now == 'R') {
                    startX = i;
                    startY = j;
                }
                if (now == 'G') {
                    endX = i;
                    endY = j;
                }
            }
        }

        int answer = -1;
        Queue<Node> nodes = new LinkedList<>();
        // init
        visited[startX][startY] = true;
        nodes.offer(new Node(startX, startY));

        while (!nodes.isEmpty()) {
            Node node = nodes.poll();
            if (node.x == endX && node.y == endY) {
                answer = answer == -1 ? node.move : Math.min(answer, node.move);
            }
            visited[node.x][node.y] = true;
            for (int[] direction : directions) {
                int nextX = node.x;
                int nextY = node.y;
                while (true) {
                    int nextStepXIndex = nextX + direction[0];
                    int nextStepYIndex = nextY + direction[1];
                    if (!(nextStepXIndex >= 0 && nextStepXIndex < map.length && nextStepYIndex >= 0 && nextStepYIndex < map[0].length)
                            || !map[nextStepXIndex][nextStepYIndex])
                        break;
                    nextX += direction[0];
                    nextY += direction[1];
                }
                if (isValid(nextX, nextY, map, visited)) {
                    visited[nextX][nextY] = true;
                    nodes.offer(new Node(nextX, nextY, node.move + 1));
                }
            }
        }

        return answer; // No path found
    }

    private static boolean isValid(int x, int y, boolean[][] map, boolean[][] visited) {
        return x >= 0 && x < map.length && y >= 0 && y < map[0].length && !visited[x][y] && map[x][y];
    }

    private static class Node {
        int x, y;
        int move;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
            this.move = 0;
        }

        Node(int x, int y, int move) {
            this.x = x;
            this.y = y;
            this.move = move;
        }
    }

    public static void main(String[] args) {
        String[] board1 = {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."};
        String[] board2 = {".D.R", "....", ".G..", "...D"};

        int result1 = L169199.solution(board1);
        int result2 = L169199.solution(board2);

        System.out.println("result1 = " + result1);
        System.out.println("result2 = " + result2);
    }
}
