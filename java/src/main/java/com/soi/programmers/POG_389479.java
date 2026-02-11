package com.soi.programmers;

public class POG_389479 {
    static int maxPersonPerServer;
    static int[] serverCount;
    static int durabilityTime;

    public static void main(String[] args) {
        int solution = solution(new int[]{0, 2, 3, 3, 1, 2, 0, 0, 0, 0, 4, 2, 0, 6, 0, 4, 2, 13, 3, 5, 10, 0, 1, 5}, 3, 5);
        System.out.println("solution = " + solution);
    }

    public static int solution(int[] players, int m, int k) {
        int answer = 0;
        maxPersonPerServer = m;
        durabilityTime = k;
        int timeCount = players.length;
        serverCount = new int[timeCount];
        for (int p = 0; p < timeCount; p++) {
            int player = players[p];
            int sc = serverCount[p];
            int minServerCount = player / maxPersonPerServer;
            if (minServerCount <= sc) {
                continue;
            }
            int increaseCount = minServerCount - sc;
            answer += increaseCount;
            for (int ic = p; ic < timeCount && ic < p + k; ic++) {
                serverCount[ic] += increaseCount;
            }
        }
        return answer;
    }
}
