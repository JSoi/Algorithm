package com.soi.programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;

public class POG_258707 {
    private static TreeSet<Integer> inHands;
    private static int targetSum;

    public static void main(String[] args) {
        System.out.println(POG_258707.solution(3, new int[]{1, 2, 3, 4, 5, 8, 6, 7, 9, 10, 11, 12}));
    }

    public static int solution(int coin, int[] c) {
        // inital draw
        inHands = new TreeSet<>();
        int n = c.length;
        targetSum = n + 1;
        Queue<Integer> cards = new LinkedList<>(Arrays.stream(c).boxed().toList());

        for (int d = 0; d < n / 3; d++) {
            inHands.add(cards.poll());
        }
        int round = 1;
        while (true) {
            // 두 개 draw
            Integer first = cards.poll();
            Integer second = cards.poll();
            int firstDrawMatch = isAbleToDraw(first);
            if (firstDrawMatch >= 0) {
                inHands.remove(firstDrawMatch);
            }
            int secondDrawMatch = isAbleToDraw(second);
            if (firstDrawMatch >= 0) {
                inHands.add(firstDrawMatch);
            }
            if (firstDrawMatch > 0 && coin > 0) {
                inHands.add(first);
                coin--;
            }
            if (secondDrawMatch > 0 && coin > 0) {
                inHands.add(second);
                coin--;
            }
            if (cards.isEmpty() || !delete()) {
                break;
            }
            round++;
        }
        return round;
    }

    public static int isAbleToDraw(Integer target) {
        if (target == null) {
            return -1;
        }
        for (int value : inHands) {
            if (target + value >= targetSum) {
                return value;
            }
        }
        return -1;
    }

    public static boolean delete() {
        for (int h : inHands) {
            Integer ceiling = inHands.ceiling(targetSum - h);
            if (ceiling != null) {
                inHands.remove(ceiling);
                inHands.remove(h);
                return true;
            }
        }
        return false;
    }
}
