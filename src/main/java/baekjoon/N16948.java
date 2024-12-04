package baekjoon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N16948 {
    static final int[][] movement = new int[][]{{-2, -1}, {-2, 1}, {0, -2}, {0, 2}, {2, -1}, {2, 1}};

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int startR = scan.nextInt();
        int startC = scan.nextInt();
        int targetR = scan.nextInt();
        int targetC = scan.nextInt();
        int[][] visit = new int[N][N];
        for (int[] v : visit) {
            Arrays.fill(v, Integer.MAX_VALUE);
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(startR, startC, 0));
        visit[startR][startC] = 0;
        while (!queue.isEmpty()) {
            Node newNode = queue.poll();
            visit[newNode.row][newNode.col] = Math.min(visit[newNode.row][newNode.col], newNode.dist);
            if (newNode.row == targetR && newNode.col == targetC) {
                break;
            }
            for (int[] mv : movement) {
                int nextR = newNode.row + mv[0];
                int nextC = newNode.col + mv[1];
                if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= N || visit[nextR][nextC] != Integer.MAX_VALUE) {
                    continue;
                }
                visit[nextR][nextC] = newNode.dist + 1;
                queue.offer(new Node(nextR, nextC, newNode.dist + 1));
            }
        }
        System.out.println(visit[targetR][targetC] == Integer.MAX_VALUE ? -1 : visit[targetR][targetC]);
    }

    private static class Node {
        int row;
        int col;
        int dist;

        public Node(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }
}
