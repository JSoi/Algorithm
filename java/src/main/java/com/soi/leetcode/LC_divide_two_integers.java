package com.soi.leetcode;

public class LC_divide_two_integers {
    public int divide(int dividend, int divisor) {
        long result = (long) dividend / divisor;
        result = Math.min(result, Integer.MAX_VALUE);
        int truncate = (int) Math.abs(result);
        return truncate * (result < 0 ? -1 : 1);
    }
}
