package com.soi.programmers;

import java.util.Arrays;

public class POG_154538 {

    public static final int MAX = Integer.MAX_VALUE;
    static int answer;

    public static void main(String[] args) {
        System.out.println(new POG_154538().solution(10, 40, 5));
    }

    //with recursion -> TO
    public static int solutionTimeout(int x, int y, int n) {
        answer = MAX;
        go(x, 0, y, n);
        return answer == MAX ? -1 : answer;
    }

    static void go(int current, int trialCount, int targetNumber, int addNumber) {
        if (current == targetNumber) {
            answer = Math.min(answer, trialCount);
            return;
        }
        if (current * 2 <= targetNumber) {
            go(current * 2, trialCount + 1, targetNumber, addNumber);
        }
        if (current * 3 <= targetNumber) {
            go(current * 3, trialCount + 1, targetNumber, addNumber);
        }
        if (current + addNumber <= targetNumber) {
            go(current + addNumber, trialCount + 1, targetNumber, addNumber);
        }
    }

    public int solution(int x, int y, int n) {
        int[] array = new int[y + 1];
        Arrays.fill(array, MAX);
        array[x] = 0;
        for (int i = x; i <= y; i++) {
            if (i % 2 == 0 && isInBoundary(i / 2, x, y) && array[i / 2] != MAX) {
                array[i] = Math.min(array[i], array[i / 2] + 1);
            }
            if (i % 3 == 0 && isInBoundary(i / 3, x, y) && array[i / 3] != MAX) {
                array[i] = Math.min(array[i], array[i / 3] + 1);
            }
            if (isInBoundary(i - n, x, y) && array[i - n] != MAX) {
                array[i] = Math.min(array[i], array[i - n] + 1);
            }
        }
        return array[y] == MAX ? -1 : array[y];
    }

    boolean isInBoundary(int index, int start, int end) {
        return index >= start && index <= end;
    }
}
