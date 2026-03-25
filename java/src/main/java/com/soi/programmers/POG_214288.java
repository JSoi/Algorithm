package com.soi.programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class POG_214288 {
    public static void main(String[] args) {
        POG_214288 problem = new POG_214288();
        int s1 = problem.solution(3, 5, new int[][]{{10, 60, 1}, {15, 100, 3}, {20, 30, 1}, {30, 50, 3}, {50, 40, 1}, {60, 30, 2}, {65, 30, 1}, {70, 100, 2}});
        System.out.println("s1 = " + s1);
        int s2 = problem.solution(2, 3, new int[][]{{5, 55, 2}, {10, 90, 2}, {20, 40, 2}, {50, 45, 2}, {100, 50, 2}});
        System.out.println("s2 = " + s2);
    }

    private static int[][] waitTime;
    private static int answer = Integer.MAX_VALUE;

    public static int solution(int k, int n, int[][] reqs) {
        List<int[]>[] waitingList = new List[k + 1];
        for (int i = 1; i <= k; i++) {
            waitingList[i] = new ArrayList<>();
        }
        for (int[] req : reqs) {
            waitingList[req[2]].add(new int[]{req[0], req[1]});
        }

        waitTime = new int[k + 1][n - k + 2]; // [type][totalConsultant]
        // 1 ~ n-k+1
        for (int type = 1; type <= k; type++) {
            for (int consultant = 1; consultant <= n - k + 1; consultant++) {
                waitTime[type][consultant] = calculateWaitTime(consultant, waitingList[type]);
            }
        }
        combination(0, n, 1, k, new int[k + 1]);
        return answer;
    }

    private static int calculateWaitTime(int tutor, List<int[]> waitingList) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(); // endtime
        int waitTime = 0;
        for (int[] info : waitingList) {
            while (!queue.isEmpty() && queue.peek() <= info[0]) {
                queue.poll();
            }
            if (!queue.isEmpty() && queue.size() >= tutor) {
                int latest = queue.peek();
                if (info[0] < latest) {
                    waitTime += latest - info[0];
                }
                queue.poll();
                queue.offer(Math.max(latest, info[0]) + info[1]);
            } else {
                queue.offer(info[0] + info[1]);

            }
        }
        return waitTime;
    }

    private static void combination(int usedConsultant, int totalConsultant, int type, int totalType, int[] result) {
        if (type > totalType) {
            if (usedConsultant == totalConsultant) {
                answer = Math.min(answer, calculateWaitTime(result));
            }
            return;
        }
        if (usedConsultant > totalConsultant || totalType - type > totalConsultant - usedConsultant) {
            return;
        }
        int leftTutors = totalConsultant - usedConsultant;
        int leftType = totalType - type;
        for (int t = 1; t <= leftTutors - leftType; t++) {
            result[type] = t;
            combination(usedConsultant + t, totalConsultant, type + 1, totalType, result);
        }

    }

    private static int calculateWaitTime(int[] result) {
        int time = 0;
        for (int i = 1; i < result.length; i++) {
            time += waitTime[i][result[i]];
        }
        return time;
    }
}
