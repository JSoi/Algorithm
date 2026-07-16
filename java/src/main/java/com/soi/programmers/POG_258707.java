package com.soi.programmers;

import java.util.PriorityQueue;

public class POG_258707 {

    public static void main(String[] args) {
        POG_258707 pog = new POG_258707();
        System.out.println(pog.solution(4, new int[]{3, 6, 7, 2, 1, 10, 5, 9, 8, 12, 11, 4})); // 5
        System.out.println(pog.solution(3, new int[]{1, 2, 3, 4, 5, 8, 6, 7, 9, 10, 11, 12})); // 2
        System.out.println(pog.solution(2, new int[]{5, 8, 1, 2, 9, 4, 12, 11, 3, 10, 6, 7})); // 4
        System.out.println(pog.solution(2, new int[]{1, 2, 3, 4, 5, 6})); // 2
        System.out.println(pog.solution(10, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18})); // 1
    }

    private int sum;
    private int[] position;
    private int n;

    public int solution(int coin, int[] c) {
        int round = 1;
        n = c.length;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        boolean[] used = new boolean[n + 1];

        position = new int[n + 1];
        for (int i = 0; i < n; i++) {
            position[c[i]] = i;
        }
        sum = n + 1;
        for (int i = 0; i < n / 3; i++) {
            used[c[i]] = true;
            if (used[sum - c[i]]) pq.offer(0);
        }

        for (int i = n / 3; i < n; i++) {
            used[c[i]] = true;
            if (used[sum - c[i]]) {
                if (position[sum - c[i]] < n / 3) {
                    pq.offer(1);
                } else {
                    pq.offer(2);
                }
            }
            if (i % 2 == 0) continue;
            if (!pq.isEmpty()) {
                int cost = pq.poll();
                if (coin - cost < 0) {
                    return round;
                }
                coin -= cost;
                round++;
            } else {
                return round;
            }
        }
        return round;
    }
}
