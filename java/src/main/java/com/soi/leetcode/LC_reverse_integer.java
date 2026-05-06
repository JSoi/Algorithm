package com.soi.leetcode;

public class LC_reverse_integer {
    public int reverse(int x) {
        long result = convert(x);
        if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
            return 0;
        }
        return (int) result;
    }

    private long convert(int x) {
        boolean isPositive = (x >= 0);
        StringBuilder sb = new StringBuilder(String.valueOf(x));
        if (isPositive) {
            return Long.parseLong(sb.reverse().toString());
        }
        return Long.parseLong(sb.deleteCharAt(sb.length() - 1).insert(0, '-').toString());
    }
}
