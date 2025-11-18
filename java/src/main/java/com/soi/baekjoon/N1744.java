package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class N1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> positive = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> negative = new PriorityQueue<>();
        PriorityQueue<Integer> zero = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(br.readLine());
            if (val > 0) {
                positive.offer(val);
            } else if (val < 0) {
                negative.offer(val);
            } else {
                zero.offer(val);
            }
        }
        long answer = 0;
        while (positive.size() > 1) {
            int first = positive.poll();
            int next = positive.poll();
            answer += Math.max(first + next, first * next);
        }
        if (!positive.isEmpty()) {
            answer += positive.poll();
        }
        while (negative.size() > 1) {
            answer += negative.poll() * negative.poll();
        }
        if (!negative.isEmpty() && zero.isEmpty()) {
            answer += negative.poll();
        }
        System.out.println(answer);
    }

}
