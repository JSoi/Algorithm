package com.soi.baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_12851 {
    static int me, sis, sisCount, sisMinVal;
    static boolean[] visit;
    static Queue<Point> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        me = scan.nextInt();
        sis = scan.nextInt();

        if (sis < me) {
            System.out.println(me - sis);
            System.out.println(1);
            return;
        }

        sisCount = 0;
        sisMinVal = Integer.MAX_VALUE;

        visit = new boolean[100001];

        bfs();

        System.out.println(sisMinVal);
        System.out.println(sisCount);

    }

    static void bfs() {
        visit[me] = true;
        queue.offer(new Point(me, 0));

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            visit[p.x] = true;
            if (p.x == sis) {
                if (sisMinVal > p.count) {
                    sisMinVal = p.count;
                    sisCount = 1;
                } else if (sisMinVal == p.count) {
                    sisCount++;
                }
                continue;
            }
            int[] dx = {p.x + 1, p.x - 1, p.x * 2};
            for (int ddx : dx) {
                if (isRange(ddx) && !visit[ddx]) {
                    queue.offer(new Point(ddx, p.count + 1));
                }
            }
        }
    }

    static boolean isRange(int input) {
        return input >= 0 && input < visit.length;
    }

    static class Point {
        int x;
        int count;

        public Point(int x, int count) {
            this.x = x;
            this.count = count;
        }
    }
}

