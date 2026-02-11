package com.soi.programmers;

public class POG_67256 {
    public static void main(String[] args) {
        String right = new POG_67256().solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right");
        System.out.println(right);
    }

    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        int leftPosition = 10;
        int rightPosition = 12;
        final String preferredHand = hand.equals("right") ? "R" : "L";
        for (int n : numbers) {
            n = n == 0 ? 11 : n;
            int hor = (n - 1) % 3;
            if (hor == 1) {
                int leftDistance = distance(n, leftPosition);
                int rightDistance = distance(n, rightPosition);
                if (leftDistance > rightDistance) {
                    answer.append("R");
                    rightPosition = n;
                } else if (leftDistance < rightDistance) {
                    answer.append("L");
                    leftPosition = n;
                } else {
                    answer.append(preferredHand);
                    if (hand.equals("right")) {
                        rightPosition = n;
                    } else {
                        leftPosition = n;
                    }
                }
            } else if (hor == 0) {
                answer.append("L");
                leftPosition = n;
            } else {
                answer.append("R");
                rightPosition = n;
            }
        }
        return answer.toString();
    }

    private int distance(int from, int to) {
        from = from == 0 ? 11 : from;
        to = to == 0 ? 11 : to;
        int fromV = (from - 1) / 3;
        int fromH = (from - 1) % 3;
        int toV = (to - 1) / 3;
        int toH = (to - 1) % 3;
        return Math.abs(fromV - toV) + Math.abs(fromH - toH);
    }
}
