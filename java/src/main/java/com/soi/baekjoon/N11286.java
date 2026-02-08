package com.soi.baekjoon;

import java.io.*;
import java.util.PriorityQueue;

public class N11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]));
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                bw.write((queue.isEmpty() ? 0 : queue.poll()[1]) + "\n");
            } else {
                queue.offer(new int[]{Math.abs(input), input});
            }
        }
        bw.flush();

    }
}
