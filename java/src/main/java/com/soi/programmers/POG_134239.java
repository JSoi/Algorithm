package com.soi.programmers;

import java.util.ArrayList;

public class POG_134239 {
    public static void main(String[] args) {
        new POG_134239().solution(5, new int[][]{{0, 0}, {0, -1}, {2, -3}, {3, -3}});
    }

    public double[] solution(int k, int[][] ranges) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(k);
        while (k > 1) {
            if (k % 2 == 0) {
                k /= 2;
            } else {
                k = k * 3 + 1;
            }
            arr.add(k);
        }
        int size = arr.size();
        double[] width = new double[size];
        double[] answer = new double[ranges.length];

        for (int i = 1; i < arr.size(); i++) {
            width[i] = ((double) arr.get(i) + arr.get(i - 1)) / 2;
        }

        int answerIdx = 0;
        for (int[] range : ranges) {
            int start = range[0];
            int end = size + range[1];
            double value = 0;
            if (end <= start) {
                value = -1;
            } else {
                for (int l = start + 1; l < end; l++) {
                    value += width[l];
                }
            }
            answer[answerIdx++] = value;
        }

        return answer;
    }
}
