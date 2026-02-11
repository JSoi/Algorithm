package com.soi.programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class POG_64061_2 {

    public static void main(String[] args) {

        System.out.println(solution(new int[][]{{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}}, new int[]{1, 5, 3, 5, 1, 2, 1, 4}));
    }

    private static int solution(int[][] board, int[] moves) {
        List<Stack<Integer>> list = new ArrayList<>();
        Stack<Integer> removeStack = new Stack<>();
        for (int j = 0; j < board.length; j++) {
            Stack<Integer> stack = new Stack<>();
            for (int i = board.length - 1; i >= 0; i--) {
                if (board[i][j] != 0) {
                    stack.push(board[i][j]);
                }
            }
            list.add(stack);
        }
        int answer = 0;
        for (int m : moves) {
            if (!list.get(m - 1).isEmpty()) {
                int target = list.get(m - 1).pop();
                if (!removeStack.isEmpty() && removeStack.peek().equals(target)) {
                    removeStack.pop();
                    answer += 2;
                } else {
                    removeStack.push(target);
                }
            }
        }
        return answer;
    }
}
