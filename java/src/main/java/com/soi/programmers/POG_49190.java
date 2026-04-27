package com.soi.programmers;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class POG_49190 {
    public static void main(String[] args) {
        int[] arrows = {6, 5, 2, 7, 1, 4, 2, 4, 6}; // 3
        int sol = solution(arrows);
        System.out.println("sol = " + sol);
    }

    private static final int[][] dir = new int[][]{{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
    private static Set<Line> lines = new HashSet<>();
    private static Set<Dot> dots = new HashSet<>();

    public static int solution(int[] arrows) {
        int answer = 0;
        int currR = 0, currC = 0;
        dots.add(new Dot(0, 0));
        for (int arrow : arrows) {
            int nextR = currR + dir[arrow][0];
            int nextC = currC + dir[arrow][1];

            if (!lines.contains(new Line(currR, currC, arrow))) {
                if (isCrossed(currR, currC, arrow)) {
                    answer++;
                }
                Line currLine = new Line(currR, currC, arrow);
                Line revLine = new Line(nextR, nextC, (arrow + 4) % 8);
                lines.add(currLine);
                lines.add(revLine);

                Dot nextDot = new Dot(nextR, nextC);
                if (dots.contains(nextDot)) {
                    answer++;
                }
                dots.add(nextDot);
            }

            currR = nextR;
            currC = nextC;

        }
        return answer;
    }

    private static class Dot {
        int r;
        int c;

        public Dot(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Dot dot = (Dot) o;
            return r == dot.r && c == dot.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(r, c);
        }
    }

    private static class Line {
        int r;
        int c;
        int beforeDir;

        public Line(int r, int c, int beforeDir) {
            this.r = r;
            this.c = c;
            this.beforeDir = beforeDir;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Line line = (Line) o;
            return r == line.r && c == line.c && beforeDir == line.beforeDir;
        }

        @Override
        public int hashCode() {
            return Objects.hash(r, c, beforeDir);
        }
    }


    private static boolean isCrossed(int r, int c, int d) {
        return switch (d) {
            case 1 -> lines.contains(new Line(r, c + 1, 7));
            case 3 -> lines.contains(new Line(r + 1, c, 1));
            case 5 -> lines.contains(new Line(r + 1, c, 7));
            case 7 -> lines.contains(new Line(r, c - 1, 1));
            default -> false;
        };
    }
}
