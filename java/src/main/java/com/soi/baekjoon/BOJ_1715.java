package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            pq.add((long) x);
        }
        if (pq.size() == 1) {
            System.out.println(0);
            return;
        }
        long answer = 0;
        while (pq.size() >= 2) {
            long first = pq.poll();
            long next = pq.poll();
            answer += first + next;
            pq.offer(first + next);
        }
        System.out.println(answer);
    }
}
