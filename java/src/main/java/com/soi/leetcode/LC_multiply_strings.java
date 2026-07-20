package com.soi.leetcode;

public class LC_multiply_strings {
    public String multiply(String num1, String num2) {
        int[] compute = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int pos = i + j + 1;
                int value = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + compute[pos];
                compute[pos] = value % 10;
                compute[pos - 1] += value / 10;
            }
        }
        StringBuilder ans = new StringBuilder();
        for (int c : compute) {
            if (!(ans.isEmpty() && c == 0)) {
                ans.append(c);
            }
        }
        return ans.isEmpty() ? "0" : ans.toString();
    }
}
