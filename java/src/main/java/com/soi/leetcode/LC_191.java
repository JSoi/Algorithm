package com.soi.leetcode;

public class LC_191 {
    public int hammingWeight(int number) {
        String str = Integer.toBinaryString(number);
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }
}
