package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_1417 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
        int dasom = Integer.parseInt(br.readLine());
        for (int i = 0; i < count - 1; i++) {
            queue.offer(new int[]{i, Integer.parseInt(br.readLine())});
        }
        int plusValue = 0;
        while (!queue.isEmpty() && queue.peek()[1] >= dasom) {
            int[] largest = queue.poll();
            queue.offer(new int[]{largest[0], largest[1] - 1});
            dasom++;
            plusValue++;
        }
        System.out.println(plusValue);
    }
}
