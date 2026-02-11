package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();
        for (char c : br.readLine().toCharArray()) {
            left.push(c);
        }
        int commandCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < commandCount; i++) {
            String command = br.readLine();
            if (command.equals("D")) {
                if (right.isEmpty()) continue;
                left.push(right.pop());
            } else if (command.equals("B")) {
                if (!left.isEmpty()) {
                    left.pop();
                }
            } else if (command.equals("L")) {
                if (left.isEmpty()) continue;
                right.push(left.pop());
            } else {
                char c = command.split(" ")[1].charAt(0);
                left.push(c);
            }
        }
        StringBuilder buf = new StringBuilder();
        String answer;
        while (!left.isEmpty()) {
            buf.append(left.pop());
        }
        answer = buf.reverse().toString();
        buf.delete(0, buf.length() + 1);
        while (!right.isEmpty()) {
            buf.append(right.pop());
        }
        answer = answer + buf;
        System.out.println(answer);
    }
}

