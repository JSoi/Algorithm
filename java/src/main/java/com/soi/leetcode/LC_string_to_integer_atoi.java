package com.soi.leetcode;

public class LC_string_to_integer_atoi {
    public static void main(String[] args) {
        LC_string_to_integer_atoi solution = new LC_string_to_integer_atoi();
//        System.out.println(solution.myAtoi("  0000000000012345678"));
        System.out.println(solution.myAtoi("0-1"));
    }

    public int myAtoi(String s) {
        s = s.replaceAll("^ +", "");
        // sign
        StringBuilder sb = new StringBuilder();
        boolean isPositive = true;
        if (s.startsWith("-") || s.startsWith("+")) {
            isPositive = !s.startsWith("-");
            s = s.substring(1);
        }
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                sb.append(c);
            } else {
                break;
            }
        }
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        if (!isPositive) sb.insert(0, "-");
        s = sb.toString();
        if (s.isEmpty() || s.equals("-") || s.equals("+")) {
            return 0;
        }
        if (s.length() > 11) {
            return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        if (Long.parseLong(s) > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (Long.parseLong(s) < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return Integer.parseInt(s);
    }
}
