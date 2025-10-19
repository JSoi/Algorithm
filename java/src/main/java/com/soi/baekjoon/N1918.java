package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class N1918 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        String input = br.readLine();
        char[] array = input.toCharArray();

        for (char c : array) {
            switch (c) {
                case '(' -> stack.push('(');
                case ')' -> {
                    if (stack.empty()) {
                        continue;
                    }
                    while (stack.peek() != '(') {
                        sb.append(stack.pop());
                    }
                    stack.pop();
                }
                case '*', '/' -> {
                    while (!stack.empty() && (stack.peek() == '*' || stack.peek() == '/')) {
                        sb.append(stack.pop());
                    }
                    stack.push(c);
                }
                case '+', '-' -> {
                    while (!stack.empty() && (stack.peek() == '*' || stack.peek() == '/' || stack.peek() == '+' || stack.peek() == '-')) {
                        sb.append(stack.pop());
                    }
                    stack.push(c);
                }
                default -> sb.append(c);
            }
        }
        while (!stack.empty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }
}
