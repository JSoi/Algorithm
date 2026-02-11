package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Long> stack = new Stack<>();
        while (n-- > 0) {
            long num = Long.parseLong(br.readLine());
            if (num == 0) {
                stack.pop();
            } else {
                stack.push(num);
            }
        }
        long answer = 0;
        while (!stack.isEmpty()) {
            answer += stack.pop();
        }
        System.out.println(answer);
    }
}
