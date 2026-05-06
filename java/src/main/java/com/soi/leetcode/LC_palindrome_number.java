package com.soi.leetcode;

/**
 * <a href = "https://leetcode.com/problems/palindrome-number" >9. Palindrome Number</a>
 */
public class LC_palindrome_number {
    public boolean isPalindrome(int x) {
        int rev = 0;
        int curr = x;
        while (curr > 0) {
            rev *= 10;
            rev += curr % 10;
            curr /= 10;
        }
        return x == rev;
    }
}
