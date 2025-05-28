package com.soi.baekjoon;

import java.util.*;

public class N13549 {
    static int sis, me, count;
    static boolean[] visit;

    public static void main(String[] args) {
        input();
        bfs();
        System.out.println(count);
    }

    static void input() {
        visit = new boolean[100001];
        Scanner scan = new Scanner(System.in);
        me = scan.nextInt();
        sis = scan.nextInt();
        count = Integer.MAX_VALUE;
    }

    static void bfs() {
        PriorityQueue<Point> queue = new PriorityQueue<>();
        queue.offer(new Point(me, 0));
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int newX = point.x;
            visit[newX] = true;
            int newCount = point.count;
            if (newX == sis) {
                count = Math.min(count, newCount);
            }
            int[] nx = {newX * 2, newX - 1, newX + 1};
            for (int i = 0; i < nx.length; i++) {
                if (isRange(nx[i]) && !visit[nx[i]]) {
                    queue.offer(new Point(nx[i], i == 0 ? newCount : (newCount + 1)));
                }
            }
        }
    }

    static class Point implements Comparable<Point> {
        int x, count;

        public Point(int x, int count) {
            this.x = x;
            this.count = count;
        }

        @Override
        public int compareTo(Point p) {
            if (this.count > p.count) {
                return 1;
            } else if (this.count == p.count) {
                return 0;
            } else return -1;
        }
    }

    static boolean isRange(int x) {
        if (x >= 0 && x < visit.length) {
            return true;
        }
        return false;
    }
}
