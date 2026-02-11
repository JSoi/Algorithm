package com.soi.baekjoon;

import java.util.*;

public class BOJ_13460 {
    private static final int[] dr = {1, 0, -1, 0};
    private static final int[] dc = {0, 1, 0, -1};
    private static int answer;
    private static int redR, redC, blueR, blueC, oR, oC;
    private static char[][] map;

    public static void main(String[] args) {
        answer = Integer.MAX_VALUE;
        Scanner scan = new Scanner(System.in);
        String[] line = scan.nextLine().split(" ");
        int m = Integer.parseInt(line[0]);
        int n = Integer.parseInt(line[1]);
        map = new char[m][n];
        for (int i = 0; i < m; i++) {
            String str = scan.nextLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'R') {
                    redR = i;
                    redC = j;
                } else if (map[i][j] == 'B') {
                    blueR = i;
                    blueC = j;
                } else if (map[i][j] == 'O') {
                    oR = i;
                    oC = j;
                }
            }
        }

        scan.close();
        move();
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    public static void move() {
        Queue<int[]> queue = new LinkedList<>();
        HashSet<Position> visited = new HashSet<>();
        queue.offer(new int[]{redR, redC, blueR, blueC, 0});
        visited.add(new Position(redR, redC, blueR, blueC));
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
//            System.out.println(Arrays.toString(curr));
            if (curr[4] > 10) continue;
            if (curr[0] == oR && curr[1] == oC) {
                answer = Math.min(answer, curr[4]);
                return;
            }
            int rR = curr[0], rC = curr[1], bR = curr[2], bC = curr[3];
            for (int k = 0; k < 4; k++) {
                Position nP = moveToDir(rR, rC, bR, bC, k);
                if (visited.contains(nP) || (nP.blueRow == oR && nP.blueCol == oC)) continue;
                visited.add(nP);
                queue.offer(new int[]{nP.redRow, nP.redCol, nP.blueRow, nP.blueCol, curr[4] + 1});
            }
        }

    }

    private static Position moveToDir(int rR, int rC, int bR, int bC, int dir) {
        if ((dir == 0 && rR > bR) || (dir == 2 && rR < bR) || (dir == 1 && rC > bC) || (dir == 3 && rC < bC)) {
            int[] newR = roll(rR, rC, dir);
            int[] newB = roll(bR, bC, dir);
            if (newB[0] == oR && newB[1] == oC) return new Position(newR[0], newR[1], newB[0], newB[1]);
            if (newR[0] == newB[0] && newR[1] == newB[1]) {
                newB[0] -= dr[dir];
                newB[1] -= dc[dir];
            }
            return new Position(newR[0], newR[1], newB[0], newB[1]);
        } else {
            int[] newB = roll(bR, bC, dir);
            int[] newR = roll(rR, rC, dir);
            if (newB[0] == oR && newB[1] == oC) return new Position(newR[0], newR[1], newB[0], newB[1]);
            if (newR[0] == newB[0] && newR[1] == newB[1]) {
                newR[0] -= dr[dir];
                newR[1] -= dc[dir];
            }
            return new Position(newR[0], newR[1], newB[0], newB[1]);
        }
    }

    private static int[] roll(int r, int c, int dir) {
        while (map[r + dr[dir]][c + dc[dir]] != '#') {
            r += dr[dir];
            c += dc[dir];
            if (r == oR && c == oC) break;
        }
        return new int[]{r, c};
    }

    private static class Position {
        int redRow;
        int redCol;
        int blueRow;
        int blueCol;

        Position(int redRow, int redCol, int blueRow, int blueCol) {
            this.redRow = redRow;
            this.redCol = redCol;
            this.blueRow = blueRow;
            this.blueCol = blueCol;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return redRow == position.redRow && redCol == position.redCol && blueRow == position.blueRow && blueCol == position.blueCol;
        }

        @Override
        public int hashCode() {
            return Objects.hash(redRow, redCol, blueRow, blueCol);
        }
    }
}
