package com.soi.programmers;

import java.util.Arrays;
import java.util.PriorityQueue;

public class L12987 {

    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int b : B) {
            pq.offer(b);
        }
        for (int a : A) {
            while (!pq.isEmpty() && pq.poll() > a) {
                answer++;
            }
        }
        return answer;
    }
}
