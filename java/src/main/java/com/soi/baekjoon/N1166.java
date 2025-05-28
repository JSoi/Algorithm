package com.soi.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class N1166 {
    public static void main(String[] args) {
        int[] input = Arrays.stream(new Scanner(System.in).nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        System.out.println(findBiggest(input[0], input[1], input[2], input[3]));
    }

    private static double findBiggest(long boxCount, long w, long h, long v) {
        double low = 0;
        double high = Math.min(w, Math.min(h, v));
        for (int i = 0; i < 100; i++) {
            double mid = (low + high) / 2;
            if ((long) (w / mid) * (long) (h / mid) * (long) (v / mid) < boxCount) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return low;
    }
}
