package com.soi.programmers;

import java.util.PriorityQueue;
import java.util.function.Function;

public class POG_468378 {
    public static void main(String[] args) {
        POG_468378 sample = new POG_468378();
        int answer = sample.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 55,  guess -> judge(3, guess));
        System.out.println("answer = " + answer);
    }

    private static int judge(int secret, int guess) {
        if (secret == guess) return 0;
        return secret < guess ? -1 : 1;
    }

    public static int solution(int[] depth, int money, Function<Integer, Integer> excavate) {
        int start = 0;
        int end = depth.length - 1;
        while (true) {
            int candidate = getCandidate(start, end, money, depth);
            System.out.println("candidate = " + candidate);
            money -= depth[candidate];
            int result = excavate.apply(candidate + 1);
            if (result == 0) {
                return candidate + 1;
            }
            if (result < 0) { // search from left
                end = candidate - 1;
            } else {
                start = candidate + 1;
            }
        }
    }

    private static int getCandidate(int start, int end, int leftMoney, int[] depth) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a1, a2) -> a1[0] == a2[0] ? a1[2] - a2[2] : a1[0] - a2[0]);
        if (start == end) return start;
        int mid = (start + end + 1) / 2;
        for (int i = start; i <= end; i++) {
            queue.offer(new int[]{depth[i], i, Math.abs(mid - i)});
        }
        if (!queue.isEmpty() && leftMoney > depth[queue.peek()[1]]) {
            queue.poll();
        }
        if (queue.isEmpty()) return start;
        return queue.peek()[1];
    }
}
