package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class BOJ_2109 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? b[1] - a[1] : b[0] - a[0]);// cost desc, day desc
        for (int i = 0; i < n; i++) {
            pq.offer(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray());
        }
        int[] schedule = new int[10_001];
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int pay = poll[0];
            int day = poll[1];
            while (day > 0) {
                if (schedule[day] == 0) {
                    schedule[day] = pay;
                    break;
                }
                day--;
            }
        }
        int answer = 0;
        for (int ss : schedule) {
            answer += ss;
        }
        System.out.println(answer);
    }
}
