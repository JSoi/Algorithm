package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ_6198 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Long> stack = new ArrayDeque<>();
        long answer = 0;
        for (int i = 0; i < n; i++) {
            long height = Long.parseLong(br.readLine());
            while (!stack.isEmpty() && stack.peek() <= height) {
                stack.pop();
            }
            answer += stack.size();
            stack.push(height);
        }
        System.out.println(answer);
    }
}
