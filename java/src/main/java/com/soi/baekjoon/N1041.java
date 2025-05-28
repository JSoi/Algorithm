package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N1041 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dice = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        if (n == 1) {
            System.out.println(oneCase(dice));
            return;
        }
        long one = (long) Math.max(0, n - 2) * Math.max(0, n - 2) + (long) Math.max(0, n - 2) * Math.max(0, n - 1) * 4;
        long two = Math.max(0, n - 2) * 8L + 4L;
        long three = 4;
        long oneValue = minOne(dice);
        long twoValue = minTwo(dice);
        long threeValue = minThree(dice);
        System.out.println(one * oneValue + two * twoValue + three * threeValue);
    }

    static long minThree(int[] dice) {
        final int[][] info = new int[][]{{0, 1, 2}, {0, 1, 3}, {0, 2, 4}, {0, 3, 4},
                {1, 2, 5}, {1, 3, 5}, {2, 4, 5}, {3, 4, 5}};
        return sumOfArr(dice, info);
    }

    static long minTwo(int[] dice) {
        final int[][] info = new int[][]{
                {0, 1}, {0, 2}, {0, 3}, {0, 4},
                {1, 2}, {1, 3}, {1, 5},
                {2, 4}, {2, 5},
                {3, 4}, {3, 5},
                {4, 5}
        };
        return sumOfArr(dice, info);
    }

    static long minOne(int[] dice) {
        return Arrays.stream(dice).min().orElse(0);
    }

    static int oneCase(int[] dice) {
        int max = 0;
        int sum = 0;
        for (int d : dice) {
            sum += d;
            max = Math.max(max, d);
        }
        return sum - max;
    }

    static int sumOfArr(int[] dice, int[][] arr) {
        int min = Integer.MAX_VALUE;
        for (int[] a : arr) {
            int sum = Arrays.stream(a).map(d -> dice[d]).sum();
            min = Math.min(sum, min);
        }
        return min;
    }
}
