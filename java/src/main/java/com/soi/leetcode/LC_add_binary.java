package com.soi.leetcode;

public class LC_add_binary {
    public static void main(String[] args) {
        LC_add_binary lc = new LC_add_binary();
        String a = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";
        String b = "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";
        String result = lc.addBinary(a, b);
        System.out.println(result);
    }
    public String addBinary(String a, String b) {
        StringBuilder answer = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;

        while (i >= 0 || j >= 0 || carry == 1) {
            if (i >= 0)
                carry += a.charAt(i--) - '0';
            if (j >= 0)
                carry += b.charAt(j--) - '0';
            answer.append(carry % 2);
            carry /= 2;
        }
        return answer.reverse().toString();
    }
}
