package com.soi.baekjoon;

import java.util.Scanner;
import java.util.Stack;

/**
 * <a href = "https://www.acmicpc.net/problem/1662">압축</a>
 */
public class N1662 {
    public static void main(String[] args) {
        long answer = 0;
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        char[] lineArr = line.toCharArray();
        sc.close();
        Stack<Long> stack = new Stack<>();
        Stack<Integer> multiplier = new Stack<>();
        stack.push(0L);
        for (int i = 0; i < lineArr.length; i++) {
            if (lineArr[i] != '(') {
                stack.push(stack.pop() + 1);
                stack.push(0L);
                continue;
            }
            // 괄호 시작
            int c = 1;
            while (c > 0 && i < lineArr.length) {
                char ch = lineArr[i];
                if (ch == '(') {
                    c++;
                    multiplier.push(lineArr[i - 1] - '0');
                    stack.set(stack.size() - 1, stack.peek() - 1);
                    stack.push(0L);
                } else if (ch == ')') {
                    long left = stack.pop();
                    stack.set(stack.size() - 1, stack.peek() + left * multiplier.pop());
                    c--;
                } else {
                    stack.set(stack.size() - 1, stack.peek() + 1);
                }
                i++;
            }
        }
        while (!stack.isEmpty()) {
            answer += stack.pop();
        }
        System.out.println(answer);
    }
}
