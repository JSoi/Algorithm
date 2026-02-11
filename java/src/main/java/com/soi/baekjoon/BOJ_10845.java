package com.soi.baekjoon;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class BOJ_10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            switch (line[0]) {
                case "pop" -> {
                    if (!queue.isEmpty()) {
                        bw.write(queue.pollFirst() + "\n");
                    } else {
                        bw.write("-1\n");
                    }
                }
                case "push" -> queue.offerLast(Integer.parseInt(line[1]));
                case "size" -> bw.write(queue.size() + "\n");
                case "empty" -> bw.write((queue.isEmpty() ? "1" : "0") + "\n");
                case "front" -> bw.write((queue.isEmpty() ? "-1" : queue.peekFirst()) + "\n");
                case "back" -> bw.write((queue.isEmpty() ? "-1" : queue.peekLast()) + "\n");
                default -> throw new IllegalStateException("Unexpected value: " + line[0]);
            }
        }
        bw.flush();

    }
}
