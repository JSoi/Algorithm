package com.soi.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC_text_justification {
    public static void main(String[] args) {

        LC_text_justification solution2 = new LC_text_justification();
        String[] words2 = {"What", "must", "be", "acknowledgment", "shall", "be"};
        int maxWidth2 = 16;
        List<String> result2 = solution2.fullJustify(words2, maxWidth2);
        for (String line : result2) {
            System.out.println("\"" + line + "\"");
        }
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> answer = new ArrayList<>();
        Pack pack = new Pack(maxWidth);
        for (String w : words) {
            if (pack.isAvailable(w)) {
                pack.addWord(w);
            } else {
                String newLine = pack.createLine();
                answer.add(newLine);
                pack.empty();
                pack.addWord(w);
            }
        }
        answer.add(pack.createLastLine());
        return answer;
    }

    static class Pack {
        private int maxLength;
        private List<String> words;
        private int wordsLength;

        Pack(int maxLength) {
            words = new ArrayList<>();
            this.maxLength = maxLength;
            this.wordsLength = 0;
        }

        boolean isAvailable(String word) {
            if (words.isEmpty())
                return true;
            return wordsLength + words.size() + word.length() <= maxLength;
        }

        void empty() {
            this.words.clear();
            this.wordsLength = 0;
        }

        void addWord(String word) {
            words.add(word);
            wordsLength += word.length();
        }

        String createLine() {
            StringBuilder sb = new StringBuilder();
            int s = words.size();
            if (s == 1) {
                int oneWordlength = words.get(0).length();
                sb.append(words.get(0)).repeat(" ", maxLength - oneWordlength);
            } else {
                int blanks = maxLength - wordsLength;
                int baseBlank = blanks / (s - 1);
                int leftBlank = blanks % (s - 1);
                for (int i = 0; i < s - 2; i++) {
                    int blank = baseBlank + (leftBlank > 0 ? 1 : 0);
                    sb.append(words.get(i)).repeat(" ", blank);
                    if (leftBlank > 0) leftBlank--;
                    blanks -= blank;
                }
                sb.append(words.get(s - 2)).repeat(" ", blanks).append(words.get(s - 1));
            }
            return sb.toString();
        }

        public String createLastLine() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < words.size() - 1; i++) {
                sb.append(words.get(i)).append(" ");
            }
            sb.append(words.get(words.size() - 1));
            while (sb.length() < maxLength) {
                sb.append(" ");
            }
            return sb.toString();
        }
    }
}
