package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N19598 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> rooms = new PriorityQueue<>();
        int[][] meetings = new int[n][2];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            meetings[i][0] = Integer.parseInt(st.nextToken());
            meetings[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));
        System.out.println(Arrays.deepToString(meetings));
        int max = 0;
        for (int[] m : meetings) {
            if (!rooms.isEmpty() && rooms.peek() <= m[0]) {
                rooms.poll();
            }
            rooms.offer(m[1]);
            max = Math.max(max, rooms.size());
//            System.out.println(rooms);
        }
        System.out.println(max);
    }
}
