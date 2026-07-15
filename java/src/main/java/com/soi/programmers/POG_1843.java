package com.soi.programmers;

import java.util.Arrays;

public class POG_1843 {
    private int[][] min;
    private int[][] max;
    private String[] input;

    public int solution(String[] arr) {
        input = arr;
        int numN = (arr.length + 1) / 2;
        min = new int[numN][numN];
        max = new int[numN][numN];
        for (int nn = 0; nn < numN; nn++) {
            Arrays.fill(min[nn], Integer.MAX_VALUE);
            Arrays.fill(max[nn], Integer.MIN_VALUE);
            min[nn][nn] = max[nn][nn] = Integer.parseInt(arr[nn * 2]);
            if (nn < numN - 1) {
                if (arr[2 * nn + 1].equals("-"))
                    min[nn][nn + 1] = max[nn][nn + 1] = Integer.parseInt(arr[nn * 2]) - Integer.parseInt(arr[nn * 2 + 2]);
                else
                    min[nn][nn + 1] = max[nn][nn + 1] = Integer.parseInt(arr[nn * 2]) + Integer.parseInt(arr[nn * 2 + 2]);
            }
        }
        return findMax(0, numN - 1);
    }

    private int findMin(int from, int to) {
        if (min[from][to] != Integer.MAX_VALUE) return min[from][to];
        int minVal = Integer.MAX_VALUE;
        for (int i = 2 * from + 1; i < 2 * to; i += 2) {
            if (input[i].equals("-")) {
                minVal = Math.min(minVal, findMin(from, i / 2) - findMax((i + 1) / 2, to));
            } else {
                minVal = Math.min(minVal, findMin(from, i / 2) + findMin((i + 1) / 2, to));
            }
        }
        return min[from][to] = minVal;
    }

    private int findMax(int from, int to) {
        if (max[from][to] != Integer.MIN_VALUE) return max[from][to];
        int maxVal = Integer.MIN_VALUE;
        for (int i = 2 * from + 1; i < 2 * to; i += 2) {
            if (input[i].equals("-")) {
                maxVal = Math.max(maxVal, findMax(from, i / 2) - findMin((i + 1) / 2, to));
            } else {
                maxVal = Math.max(maxVal, findMax(from, i / 2) + findMax((i + 1) / 2, to));
            }
        }
        return max[from][to] = maxVal;
    }
}
