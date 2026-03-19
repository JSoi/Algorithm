package com.soi.programmers;

import java.util.ArrayList;
import java.util.List;

public class POG_468370 {
    public static void main(String[] args) {
        solution("my phone number is 01012345678 and may i have your phone number", new int[][]{{5, 5}, {25, 28}, {34, 40}, {53, 59}});
    }

    private static int wordCount;
    private static String[] words;
    private static boolean[] isMasked;


    public static int solution(String message, int[][] spoilerRanges) {
        words = message.split(" ");
        wordCount = words.length;
        isMasked = new boolean[wordCount];

        List<Integer>[] spoilerInfo = new List[spoilerRanges.length];
        for (int i = 0; i < spoilerInfo.length; i++) {
            spoilerInfo[i] = getSpoilerWordIdx(spoilerRanges[i][0], spoilerRanges[i][1]);
            for (int spoilerIdx : spoilerInfo[i]) {
                isMasked[spoilerIdx] = true;
            }
        }

        boolean[] isImportant = new boolean[wordCount];
        for (List<Integer> spoilerIdxes : spoilerInfo) {
            for (int spoilerIdx : spoilerIdxes) {
                if (!hasDuplicate(spoilerIdx)) {
                    isImportant[spoilerIdx] = true;
                }
                isMasked[spoilerIdx] = false;
            }
        }
        int answer = 0;
        for (int i = 0; i < wordCount; i++) {
            if (isImportant[i]) {
                answer++;
            }
        }
        return answer;
    }

    private static boolean hasDuplicate(int wordIdx) {
        for (int i = 0; i < wordCount; i++) {
            if (words[i].equals(words[wordIdx]) && i != wordIdx && !isMasked[i]) {
                return true;
            }
        }
        return false;
    }

    private static List<Integer> getSpoilerWordIdx(int start, int end) {
        ArrayList<Integer> wordIdxes = new ArrayList<>();
        int idx = 0;
        for (int s = 0; s < words.length; s++) {
            int subStart = idx;
            int subEnd = idx + words[s].length() - 1;
            if (start <= subEnd && subStart <= end) {
                wordIdxes.add(s);
            }
            idx = subEnd + 2;
        }
        return wordIdxes;
    }
}
