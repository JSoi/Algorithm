package com.soi.programmers;

import java.util.Arrays;

public class POG_17685 {
    public int solution(String[] words) {
        Arrays.sort(words);
        int total = 0;
        for (int i = 0; i < words.length; i++) {
            if (i == 0) {
                total += typeCount(words[i], words[i + 1]);
            } else if (i == words.length - 1) {
                total += typeCount(words[i], words[i - 1]);
            } else {
                total += Math.max(typeCount(words[i], words[i - 1]), typeCount(words[i], words[i + 1]));
            }
        }
        return total;
    }

    public int typeCount(String w1, String w2) {
        int idx = 0;
        int maxLen = Math.min(w1.length(), w2.length());
        // 단어 중복 없음
        while (idx < maxLen) {
            if (w1.charAt(idx) != w2.charAt(idx)) {
                return idx + 1;
            }
            idx++;
        }
        return w1.length() == maxLen ? maxLen : idx + 1;
    }
}
