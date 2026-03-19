package com.soi.programmers;

import java.util.Arrays;

public class POG_468371 {
    public static void main(String[] args) {
        int s = solution(new int[][]{{1, 2, 3}, {2, 1, 3}});
        System.out.println("s = " + s);
    }

    public static final int MAX_TIME = (int) Math.pow(20, 5);
    private static int n;
    private static int[][] signals;

    public static int solution(int[][] s) {
        // G Y R
        n = s.length;
        signals = new int[s.length][3];
        for (int i = 0; i < n; i++) {
            signals[i] = Arrays.copyOf(s[i], 3);
        }
        for (int t = 0; t <= MAX_TIME; t++) {
            if (isYellowSignal(t)) {
                return t;
            }
        }
        return -1;
    }

    private static boolean isYellowSignal(int time) {
        for (int i = 0; i < n; i++) {
            int adjusted = time % (signals[i][0] + signals[i][1] + signals[i][2]);
            if (adjusted <= signals[i][0] || adjusted > signals[i][0] + signals[i][1]) {
                return false;
            }
        }
        return true;
    }
}
