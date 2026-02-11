package com.soi.programmers;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class POG_60059 {
    public static void main(String[] args) {
//        boolean solution = new POG_60059().solution(new int[][]{{0, 0, 0}, {1, 0, 0}, {0, 1, 1}}, new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}});
        boolean solution = new POG_60059().solution(new int[][]{{1, 1}, {1, 1}}, new int[][]{{1, 1, 1, 1}, {1, 0, 0, 1}, {1, 0, 0, 1}, {1, 1, 1, 1}});
        System.out.println("solution = " + solution);
    }

    public boolean solution(int[][] key, int[][] lock) {
        Matrix[] rotatedKeyArr = new Matrix[4];
        rotatedKeyArr[0] = new Matrix(key.length);
        rotatedKeyArr[0].setPositions(key, true);
        for (int i = 1; i < 4; i++) {
            rotatedKeyArr[i] = new Matrix(key.length);
            rotatedKeyArr[i].positions = rotatedKeyArr[i - 1].positions.stream()
                    .map(p -> p.createRotatedPosition(key.length))
                    .collect(Collectors.toCollection(HashSet::new));
        }
        Matrix lockMatrix = new Matrix(lock.length);
        lockMatrix.setPositions(lock, false);
        if (lockMatrix.positions.isEmpty()) {
            return true;
        }
        for (int i = 0; i < 4; i++) {
            rotatedKeyArr[0].positions.forEach(p -> p.move(-key.length + 1, -key.length + 1));
            // 3 -> -2 == 1
            for (int rM = -key.length + 1; rM <= key.length + lock.length; rM++) {
                for (int cM = -key.length + 1; cM <= key.length + lock.length; cM++) {
                    int finalRM = rM;
                    int finalCM = cM;
                    HashSet<Position> movedSet = rotatedKeyArr[i].positions.stream()
                            .map(p -> new Position(p.r + finalRM, p.c + finalCM))
                            .filter(p -> p.c >= 0 && p.c < lock[0].length && p.r >= 0 && p.r < lock.length)
                            .collect(Collectors.toCollection(HashSet::new));
                    if (movedSet.size() == lockMatrix.positions.size() && movedSet.containsAll(lockMatrix.positions)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static class Matrix {
        int len;
        Set<Position> positions;

        public Matrix(int len) {
            this.len = len;
            this.positions = new HashSet<>();
        }

        public void setPositions(int[][] arr, boolean isOne) {
            for (int r = 0; r < arr.length; r++) {
                for (int c = 0; c < arr[0].length; c++) {
                    if ((isOne && arr[r][c] == 1) || (!isOne && arr[r][c] == 0)) {
                        this.positions.add(new Position(r, c));
                    }
                }
            }
        }
    }

    private static class Position {
        int r;
        int c;


        public Position(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public void move(int moveR, int moveC) {
            this.r += moveR;
            this.c += moveC;
        }

        public Position createRotatedPosition(int totalRow) {
            return new Position(this.c, totalRow - this.r - 1);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return r == position.r && c == position.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(r, c);
        }
    }
}
