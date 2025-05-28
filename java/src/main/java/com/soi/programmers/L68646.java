package com.soi.programmers;

public class L68646 {
    public static void main(String[] args) {
        int solution = new L68646().solution(new int[]{-16, 27, 65, -2, 58, -92, -71, -68, -61, -33});
        System.out.println("solution = " + solution);
    }

    public int solution(int[] a) { // a -> [1, 1,000,000]
        int answer = 0;
        final int MIN = 0;
        final int MAX = 1;
        final int LEFT = 0;
        final int RIGHT = 1;
        int[][][] arr = new int[a.length][2][2];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            arr[i][MIN][LEFT] = min;
            arr[i][MAX][LEFT] = max;
            min = Math.min(min, a[i]);
            max = Math.max(max, a[i]);
        }
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        for (int i = a.length - 1; i >= 0; i--) {
            arr[i][MIN][RIGHT] = min;
            arr[i][MAX][RIGHT] = max;
            min = Math.min(min, a[i]);
            max = Math.max(max, a[i]);
        }
        for (int i = 0; i < a.length; i++) {
            if (i == 0 || i == a.length - 1) {
                answer++;
                continue;
            }
            int lMin = arr[i][MIN][LEFT];
            int rMin = arr[i][MIN][RIGHT];
            int lMax = arr[i][MAX][LEFT];
            int rMax = arr[i][MAX][RIGHT];
            int current = a[i];
            if ((Math.min(lMin, rMin) < current && Math.max(lMin, rMin) > current) ||
                    (Math.min(lMin, rMin) > current) ||
                    (lMax > current && rMin > current) ||
                    (rMax > current && lMin > current)) {
                answer++;
            }
        }
        return answer;
    }
}
