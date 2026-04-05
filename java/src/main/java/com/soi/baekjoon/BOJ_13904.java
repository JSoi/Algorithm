package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_13904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Work> pq = new PriorityQueue<>();
        int maxTime = 0;
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int deadLine = Integer.parseInt(st.nextToken());
            int point = Integer.parseInt(st.nextToken());
            maxTime = Math.max(maxTime, deadLine);
            pq.offer(new Work(deadLine, point));
        }
        boolean[] workDone = new boolean[maxTime + 1];
        workDone[0] = true;
        int point = 0;
        while (!pq.isEmpty()) {
            Work w = pq.poll();
            if (canFillWork(workDone, w)) {
                workDone[w.deadLine] = true;
                point += w.point;
            }
        }
        System.out.println(point);
    }

    private static class Work implements Comparable<Work> {
        int deadLine;
        int point;

        Work(int deadLine, int point) {
            this.deadLine = deadLine;
            this.point = point;
        }

        @Override
        public int compareTo(Work work) {
            if (this.point == work.point) {
                return this.deadLine - work.deadLine; // desc
            }
            return work.point - this.point;
        }
    }

    private static boolean canFillWork(boolean[] workDone, Work work) {
        int workDeadLine = work.deadLine;
        for (int dl = workDeadLine; dl > 0; dl--) {
            if (!workDone[dl]) {
                workDone[dl] = true;
                return true;
            }
        }
        return false;
    }
}
