package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ_11000 {
    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(Integer::intValue));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        int classCount = Integer.parseInt(br.readLine());
        int[][] classes = new int[classCount][2];
        for (int i = 0; i < classCount; i++) {
            String[] values = br.readLine().split(" ");
            classes[i][0] = Integer.parseInt(values[0]);
            classes[i][1] = Integer.parseInt(values[1]);
        }
        Arrays.sort(classes, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        for (int[] c : classes) {
            int startTime = c[0];
            if (pq.isEmpty() || pq.peek() > startTime) {
                pq.offer(c[1]);
            } else {
                pq.poll();
                pq.offer(c[1]);
            }
            answer = Math.max(answer, pq.size());
        }
        System.out.println(answer);
    }
}
