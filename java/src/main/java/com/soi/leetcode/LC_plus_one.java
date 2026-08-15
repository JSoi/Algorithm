package com.soi.leetcode;

public class LC_plus_one {
    public int[] plusOne(int[] digits) {
        StringBuilder answer = new StringBuilder();
        int carry = 1;
        int i = digits.length - 1;
        while (i >= 0 || carry > 0) {
            if (i >= 0) {
                carry += digits[i--];
            }
            answer.insert(0, carry % 10);
            carry /= 10;
        }
        int[] result = new int[answer.length()];
        for (int ii = 0; ii < answer.length(); ii++) {
            result[ii] = answer.charAt(ii) - '0';
        }
        return result;
    }
}
