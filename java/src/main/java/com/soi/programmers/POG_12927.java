package com.soi.programmers;

import java.util.Collections;
import java.util.PriorityQueue;

public class POG_12927 {
    // queue - 우선순위
    public static void main(String[] args) {
        long solution = new POG_12927().solution(1, new int[]{2, 1, 2});
        System.out.println(solution);
    }

    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int work : works) {
            queue.offer(work);
        }
        while (n > 0) {
            int biggest = queue.poll();
            if (biggest == 0) {
                break;
            }
            queue.offer(biggest - 1);
            n--;
        }
        while (!queue.isEmpty()) {
            int value = queue.poll();
            answer += (long) value * value;
        }
        return answer;
    }

}
