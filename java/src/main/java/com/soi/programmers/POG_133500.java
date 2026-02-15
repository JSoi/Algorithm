package com.soi.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class POG_133500 {
    public static void main(String[] args) {
        int s1 = new POG_133500().solution(8, new int[][]{{1, 2}, {1, 3}, {1, 4}, {1, 5}, {5, 6}, {5, 7}, {5, 8}});
        int s2 = new POG_133500().solution(10, new int[][]{{4, 1}, {5, 1}, {5, 6}, {7, 6}, {1, 2}, {1, 3}, {6, 8}, {2, 9}, {9, 10}});
        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
    }

    public static final int MAX = Integer.MAX_VALUE;
    private static List<Integer>[] conn;
    private static int N;

    private static int[][] bulbCount;


    public int solution(int n, int[][] lighthouse) {
        N = n;
        conn = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            conn[i] = new ArrayList<>();
        }
        for (int[] lh : lighthouse) {
            conn[lh[0]].add(lh[1]);
            conn[lh[1]].add(lh[0]);
        }
        bulbCount = new int[N + 1][2];
        for (int i = 0; i <= N; i++)
            Arrays.fill(bulbCount[i], -1);
        return Math.min(calculate(0, 1, false), calculate(0, 1, true));
    }

    private static int calculate(int prev, int curr, boolean isOn) {
        int state = isOn ? 1 : 0;
        if (bulbCount[curr][state] != -1)
            return bulbCount[curr][state];

        if (conn[curr].size() == 1 && conn[curr].get(0).equals(prev)) {
            return bulbCount[curr][state] = isOn ? 1 : 0;
        }

        for (int next : conn[curr]) {
            if (next == prev) continue;
            calculate(curr, next, true);
            calculate(curr, next, false);
        }

        int sumMin = 0;
        int sumAllOn = 0;

        for (int next : conn[curr]) {
            if (next == prev) continue;
            sumMin += Math.min(bulbCount[next][0], bulbCount[next][1]);
            sumAllOn += bulbCount[next][1];
        }

        if (isOn) {
            return bulbCount[curr][1] = 1 + sumMin;
        } else {
            return bulbCount[curr][0] = sumAllOn;
        }
    }
}
