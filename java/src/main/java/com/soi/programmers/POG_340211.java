package com.soi.programmers;

import java.util.HashMap;
import java.util.Objects;

public class POG_340211 {
    static HashMap<Point, Integer> pointOfTime;
    static int targetRow, targetCol;
    static int time;

    public static void main(String[] args) {
//        int solution = new POG_340211().solution(new int[][]{{3, 2}, {6, 4}, {4, 7}, {1, 4}}, new int[][]{{4, 2}, {1, 3}, {2, 4}});
        int solution = solution(new int[][]{{2, 2}, {2, 3}, {2, 7}, {6, 6}, {5, 2}}, new int[][]{{2, 3, 4, 5}, {1, 3, 4, 5}});
        System.out.println("solution = " + solution);
    }

    public static int solution(int[][] points, int[][] routes) {
        pointOfTime = new HashMap<>();
        for (int[] route : routes) {
            time = 1;
            Point newPoint = new Point(points[route[0] - 1][0] - 1, points[route[0] - 1][1] - 1, time);
            pointOfTime.put(newPoint, pointOfTime.getOrDefault(newPoint, 0) + 1);
            for (int ri = 0; ri < route.length - 1; ri++) {
                int fromPoint = route[ri];
                int toPoint = route[ri + 1];
                int fromRow = points[fromPoint - 1][0] - 1;
                int fromCol = points[fromPoint - 1][1] - 1;

                targetRow = points[toPoint - 1][0] - 1;
                targetCol = points[toPoint - 1][1] - 1;
                addPoints(fromRow, fromCol);
            }
        }
        return (int) pointOfTime.entrySet().stream().filter(e -> e.getValue() > 1).count();
    }

    private static void addPoints(int startR, int startC) {
//        System.out.println(String.format("[%d %d] -> [%d %d]", startR, startC, targetRow, targetCol));
        // 상 하 좌 우
        Point newPoint;
        while (startR != targetRow) {
            if (startR < targetRow) { // down
                newPoint = new Point(++startR, startC, ++time);
            } else { // up
                newPoint = new Point(--startR, startC, ++time);
            }
            pointOfTime.put(newPoint, pointOfTime.getOrDefault(newPoint, 0) + 1);
        }
        while (startC != targetCol) {
            if (startC < targetCol) { // to right
                newPoint = new Point(startR, ++startC, ++time);
            } else { // to left
                newPoint = new Point(startR, --startC, ++time);
            }
            pointOfTime.put(newPoint, pointOfTime.getOrDefault(newPoint, 0) + 1);
        }
    }

    private static class Point {
        int row;
        int col;
        int time;

        public Point(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }

        @Override
        public String toString() {
            return "[" + row +
                    ", " + col +
                    "] -> time=" + time +
                    ']';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return row == point.row && col == point.col && time == point.time;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col, time);
        }
    }
}
