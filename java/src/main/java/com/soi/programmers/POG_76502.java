package com.soi.programmers;

import java.util.Stack;

public class POG_76502 {
    public static void main(String[] args) {
        int answer = new POG_76502().solution("[(){{}}]");
        System.out.println(answer);

    }

    public int solution(String s) {
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            String target = s.substring(i) + s.substring(0, i);
            answer += check(target) ? 1 : 0;
        }
        return answer;
    }

    boolean check(String input) {
        Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray()) {
            if ("{[(".contains(String.valueOf(c))) {
                stack.push(c);
            } else {
                char opposite = switch (c) {
                    case ')' -> '(';
                    case ']' -> '[';
                    case '}' -> '{';
                    default -> throw new IllegalArgumentException();
                };
                if (stack.isEmpty() || stack.peek() != opposite) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
}
