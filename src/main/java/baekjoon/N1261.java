package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class N1261 {
    static int[][] cost;
    static boolean[][] isBlank;
    static int row;
    static int col;
    static final int[][] movement = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dest = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        row = dest[1];
        col = dest[0];
        cost = new int[row][col];
        isBlank = new boolean[row][col];
        for (int[] c : cost) {
            Arrays.fill(c, Integer.MAX_VALUE);
        }
        for (int i = 0; i < row; i++) {
            String line = br.readLine();
            for (int j = 0; j < col; j++) {
                isBlank[i][j] = line.charAt(j) == '0';
            }
        }
        LinkedList<Position> queue = new LinkedList<>();
        queue.offer(new Position(0, 0, 0));
        cost[0][0] =0;
        while (!queue.isEmpty()) {
            Position pos = queue.poll();
            if (pos.r == row - 1 && pos.c == col - 1) {
                continue;
            }
            for (int[] m : movement) {
                int nR = pos.r + m[0];
                int nC = pos.c + m[1];
                int nB = pos.breakCount;
                if (!isInRange(nR, nC) || cost[nR][nC] <= (nB = nB + (isBlank[nR][nC] ? 0 : 1))) {
                    continue;
                }
                cost[nR][nC] = Math.min(cost[nR][nC], nB);
                queue.offer(new Position(nR, nC, nB));
            }
        }
        System.out.println(cost[row - 1][col - 1]);

    }

    static boolean isInRange(int r, int c) {
        return r >= 0 && r < row && c >= 0 && c < col;
    }

    static class Position {
        int r;
        int c;
        int breakCount;

        public Position(int r, int c, int breakCount) {
            this.r = r;
            this.c = c;
            this.breakCount = breakCount;
        }
    }
}
