package com.soi.leetcode;

public class LC_length_of_last_word {
    public int lengthOfLastWord(String s) {
        int firstWordIdx = s.length() - 1;
        while (s.charAt(firstWordIdx) == ' ') {
            firstWordIdx--;
        }
        int firstWordStartIdx = firstWordIdx;
        while (firstWordStartIdx >= 0 && s.charAt(firstWordStartIdx) != ' ') {
            firstWordStartIdx--;
        }
        return firstWordIdx - firstWordStartIdx;
    }
}
