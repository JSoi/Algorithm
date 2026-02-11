package com.soi.programmers;

public class POG_150369 {
    public static void main(String[] args) {
        long solution = new POG_150369().solution(4, 5, new int[]{1, 0, 3, 1, 2}, new int[]{0, 3, 0, 4, 0});
        System.out.println("solution = " + solution);
    }

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int pickUpSum = 0, deliverySum = 0;
        for (int i = n - 1; i >= 0; i--) {
            deliverySum += deliveries[i];
            pickUpSum += pickups[i];
            while (deliverySum > 0 || pickUpSum > 0) {
                deliverySum -= cap;
                pickUpSum -= cap;
                answer += 2L * (i + 1);
            }
        }
        return answer == 0 ? -1 : answer;
    }
}
