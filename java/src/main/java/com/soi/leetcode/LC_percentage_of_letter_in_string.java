package com.soi.leetcode;

public class LC_percentage_of_letter_in_string {
    public int percentageLetter(String s, char letter) {
        int count = 0;
        for (char l : s.toCharArray()) {
            if (l == letter)
                count++;
        }
        return (count * 100) / s.length();
    }
}
