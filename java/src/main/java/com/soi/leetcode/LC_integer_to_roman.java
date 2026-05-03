package com.soi.leetcode;

public class LC_integer_to_roman {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        if (num / 1000 != 0) {
            sb.append("M".repeat(num / 1000));
        }
        if (num / 100 != 0) {
            int digit = (num % 1000) / 100;
            if (digit == 9) {
                sb.append("CM");
            } else if (digit == 4) {
                sb.append("CD");
            } else {
                sb.append("D".repeat(digit / 5)).append("C".repeat(digit % 5));
            }
        }
        if (num / 10 != 0) {
            int digit = (num % 100) / 10;
            if (digit == 9) {
                sb.append("XC");
            } else if (digit == 4) {
                sb.append("XL");
            } else {
                sb.append("L".repeat(digit / 5)).append("X".repeat(digit % 5));
            }
        }
        if (num % 10 != 0) {
            int digit = num % 10;
            if (digit == 9) {
                sb.append("IX");
            } else if (digit == 4) {
                sb.append("IV");
            } else {
                sb.append("V".repeat(digit / 5)).append("I".repeat(digit % 5));
            }
        }
        return sb.toString();
    }
}
