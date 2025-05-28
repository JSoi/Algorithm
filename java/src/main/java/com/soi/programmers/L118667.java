package com.soi.programmers;

import com.soi.tool.Assertions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class L118667 {
    public static void main(String[] args) throws Exception {
        Assertions.check(L118667.solution(new int[]{3, 2, 7, 2}, new int[]{4, 6, 5, 1}), 2);
        Assertions.check(L118667.solution(new int[]{1, 2, 1, 2}, new int[]{1, 10, 1, 2}), 7);
    }

    public static int solution(int[] queue1, int[] queue2) {
        long q1Sum = Arrays.stream(queue1).asLongStream().sum();
        long q2Sum = Arrays.stream(queue2).asLongStream().sum();

        // 총합이 홀수면 -1 반환
        if ((q1Sum + q2Sum) % 2 != 0) {
            return -1;
        }

        Queue<Integer> q1 = new LinkedList<>(Arrays.stream(queue1).boxed().collect(Collectors.toCollection(ArrayList::new)));
        Queue<Integer> q2 = new LinkedList<>(Arrays.stream(queue2).boxed().collect(Collectors.toCollection(ArrayList::new)));

        int moveCount = 0;
        int answer = -1;

        while (moveCount <= queue1.length + queue2.length + 2) {
            if (q1Sum == q2Sum) {
                return moveCount;
            }
            int pollElement;
            if (q1Sum > q2Sum) {
                pollElement = q1.poll();
                q1Sum -= pollElement;
                q2Sum += pollElement;
                q2.offer(pollElement);
            } else {
                pollElement = q2.poll();
                q1Sum += pollElement;
                q2Sum -= pollElement;
                q1.offer(pollElement);
            }
            moveCount++;
        }
        return answer;
    }
}
