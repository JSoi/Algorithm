package com.soi.leetcode;

public class LC_count_and_say {
    public String countAndSay(int n) {
        return recursive(n);
    }

    public String recursive(int n) {
        if (n == 1)
            return "1";
        StringBuilder sb = new StringBuilder();
        String curr = recursive(n - 1);
        int i = 0;
        while (i < curr.length()) {
            int count = 0;
            char c = curr.charAt(i);
            while (i < curr.length() && curr.charAt(i) == c) {
                count++;
                i++;
            }
            String join = String.valueOf(count) + c;
            sb.append(join);
        }
        return sb.toString();
    }
}
