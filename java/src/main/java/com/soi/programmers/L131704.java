package com.soi.programmers;

import com.soi.tool.Assertions;

import java.util.Stack;

public class L131704 {
    public static void main(String[] args) throws Exception {
        System.out.println();
        Assertions.check(new L131704().solution(new int[]{4, 3, 1, 2, 5}), 2);
        Assertions.check(new L131704().solution(new int[]{5, 4, 3, 2, 1}), 5);
        Assertions.check(new L131704().solution(new int[]{6, 7, 5, 4, 3, 2, 1}), 7);

    }

    public int solution(int[] order) {
        Stack<Integer> stack = new Stack<>();
        int orderIndex = 0;
        for (int count = 1; count <= order.length; count++) {
            stack.push(count);
            while (!stack.isEmpty() && stack.peek() == order[orderIndex]) {
                orderIndex++;
                stack.pop();
            }
        }
        return orderIndex;
    }
}
