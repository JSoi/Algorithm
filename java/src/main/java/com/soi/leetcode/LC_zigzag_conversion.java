package com.soi.leetcode;

public class LC_zigzag_conversion {
    private static class Solution {
        public String convert(String s, int numRows) {
            int chunkSize = numRows == 1 ? 1 : (2 * numRows - 2);
            StringBuilder[] builds = new StringBuilder[numRows];
            for (int i = 0; i < numRows; i++) {
                builds[i] = new StringBuilder();
            }
            int idx = 0;
            for (char c : s.toCharArray()) {
                int chunkIdx = idx % chunkSize;
                int rr = chunkIdx < numRows ? chunkIdx : (numRows - (chunkIdx - numRows + 2));
                builds[rr].append(c);
                idx++;
            }
            StringBuilder sb = new StringBuilder();
            for (int r = 0; r < numRows; r++) {
                sb.append(builds[r].toString());
            }
            return sb.toString();
        }
    }
}
