package com.soi.leetcode;

public class LC_sqrtx {
    public int mySqrt(int x) {
        if (x <= 1)
            return x;
        int l = 1;
        int r = x;
        int mid;
        int answer = 0;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (mid <= x / mid) {
                answer = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return answer;
    }
}
