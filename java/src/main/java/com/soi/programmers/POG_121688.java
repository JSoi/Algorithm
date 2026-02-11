package com.soi.programmers;

import java.util.PriorityQueue;

public class POG_121688 {
    public static void main(String[] args) {

    }

    public int solution(int[] ability, int number) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int a : ability) {
            pq.offer(a);
        }
        while (number > 0) {
            int a = pq.poll();
            int b = pq.poll();
            pq.offer(a + b);
            pq.offer(a + b);
            number--;
        }
        while (!pq.isEmpty()) {
            answer += pq.poll();
        }
        return answer;
    }
}
