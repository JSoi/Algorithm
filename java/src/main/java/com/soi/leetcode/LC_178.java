package com.soi.leetcode;

//https://leetcode.com/problems/first-bad-version/
public class LC_178 {
    public boolean isBadVersion(int index) { // super class에 명시되어 있으나 명확하지 않아서 작성하지 않음
        return true;
    }

    public int firstBadVersion(int n) {
        int start = 1, end = n;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isBadVersion(mid)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
