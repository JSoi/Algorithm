package com.soi.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class POG_60063 {
    public static void main(String[] args) {
        int solution = new POG_60063().solution(new int[][]{{0, 0, 0, 1, 1}, {0, 0, 0, 1, 0}, {0, 1, 0, 1, 1}, {1, 1, 0, 0, 1}, {0, 0, 0, 0, 0}});
        System.out.println("solution = " + solution);
    }

    private static int r, c;
    private static boolean[][] isWall;
    private static final int[][] move = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    private static boolean[][][] visit;
    public static int solution(int[][] board) {
        r = board.length;
        c = board[0].length;
        isWall = new boolean[r][c];
        visit = new boolean[r][c][2];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                isWall[i][j] = board[i][j] == 1;
            }
        }
        Queue<Robot> queue = new LinkedList<>();
        queue.offer(new Robot(0, 0, false, 0));
        while (!queue.isEmpty()) {
            Robot current = queue.poll();
            if ((current.r == r - 1 && current.c == c - 1) || (current.rr == r - 1 && current.cc == c - 1)) {
                return current.count;
            }
            for (int moveIdx = 0; moveIdx < 4; moveIdx++) {
                if (!current.canMove(moveIdx)) {
                    continue;
                }
                Robot next = current.move(moveIdx);
                if (!visit[next.r][next.c][next.isVertical ? 1 : 0]) {
                    visit[next.r][next.c][next.isVertical ? 1 : 0] = true;
                    queue.offer(next);
                }
            }
            for (int rotateStatus = 0; rotateStatus < 4; rotateStatus++) {
                boolean clockWise = (rotateStatus & 2) == 0;
                boolean pivotFixed = (rotateStatus & 1) == 0;
                if (!current.canRotate(clockWise, pivotFixed)) {
                    continue;
                }
                Robot next = current.rotate(clockWise, pivotFixed);
                if(!visit[next.r][next.c][next.isVertical ? 1 : 0]){
                    visit[next.r][next.c][next.isVertical ? 1 : 0] = true;
                    queue.offer(next);
                }
            }
        }
        return 0;
    }

    private static class Robot {
        int r;
        int c;
        int rr;
        int cc;
        boolean isVertical;
        int count;

        public Robot(int r, int c, boolean isVertical, int count) {
            this.r = r;
            this.c = c;
            this.isVertical = isVertical;
            this.rr = isVertical ? r + 1 : r;
            this.cc = isVertical ? c : c + 1;
            this.count = count;
        }

        public Robot move(int moveIdx) {
            return new Robot(this.r + move[moveIdx][0], this.c + move[moveIdx][1], this.isVertical, this.count + 1);
        }

        public Robot rotate(boolean clockwise, boolean pivotFixed) {
            int nR, nC;
            if (isVertical) {
                if (pivotFixed) {
                    nR = r;
                    nC = clockwise ? c - 1 : c;
                } else {
                    nR = r + 1;
                    nC = clockwise ? c : c - 1;
                }
            } else {
                if (pivotFixed) {
                    nR = clockwise ? r : r - 1;
                    nC = c;
                } else {
                    nR = clockwise ? r - 1 : r;
                    nC = c + 1;
                }
            }
            return new Robot(nR, nC, !this.isVertical, count + 1);
        }

        public boolean canMove(int moveIdx) {
            int nR = this.r + move[moveIdx][0];
            int nC = this.c + move[moveIdx][1];
            int nRR = this.rr + move[moveIdx][0];
            int nCC = this.cc + move[moveIdx][1];
            return inRange(nR, nC) && inRange(nRR, nCC) && !isWall[nR][nC] && !isWall[nRR][nCC];
        }

        public boolean canRotate(boolean clockwise, boolean pivotFixed) {
            int r1, c1, r2, c2;
            if (isVertical) {
                if (pivotFixed) {
                    if (clockwise) {
                        r1 = this.r;
                        c1 = this.c - 1;
                        r2 = this.rr;
                        c2 = this.cc - 1;
                    } else {
                        r1 = this.r;
                        c1 = this.c + 1;
                        r2 = this.rr;
                        c2 = this.cc + 1;
                    }
                } else {
                    if (clockwise) {
                        r1 = this.r;
                        c1 = this.c + 1;
                        r2 = this.rr;
                        c2 = this.cc + 1;
                    } else {
                        r1 = this.r;
                        c1 = this.c - 1;
                        r2 = this.rr;
                        c2 = this.cc - 1;
                    }
                }
            } else { // 가로
                if (pivotFixed) {
                    if (clockwise) {
                        r1 = this.r + 1;
                        c1 = this.c;
                        r2 = this.rr + 1;
                        c2 = this.cc;
                    } else {
                        r1 = this.r - 1;
                        c1 = this.c;
                        r2 = this.rr - 1;
                        c2 = this.cc;
                    }
                } else {
                    if (clockwise) {
                        r1 = this.r - 1;
                        c1 = this.c;
                        r2 = this.rr - 1;
                        c2 = this.cc;
                    } else {
                        r1 = this.r + 1;
                        c1 = this.c;
                        r2 = this.rr + 1;
                        c2 = this.cc;
                    }
                }
            }
            return inRange(r1, c1) && inRange(r2, c2) && !isWall[r1][c1] && !isWall[r2][c2];
        }
    }

    private static boolean inRange(int rr, int cc) {
        return rr >= 0 && cc >= 0 && rr < r && cc < c;
    }

}
