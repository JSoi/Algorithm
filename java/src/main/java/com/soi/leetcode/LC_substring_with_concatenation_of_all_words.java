package com.soi.leetcode;

import java.util.*;

public class LC_substring_with_concatenation_of_all_words {
    public static void main(String[] args) {
        LC_substring_with_concatenation_of_all_words solution = new LC_substring_with_concatenation_of_all_words();
        List<Integer> result = solution.findSubstring("barfoofoobarthefoobarman", new String[]{"bar", "foo", "the"});
        System.out.println(result);
    }

    private String sentence;
    private int len, wordCount;
    private Map<String, Integer> countMap;
    private List<Integer> answer;

    public List<Integer> findSubstring(String s, String[] words) {
        this.sentence = s;
        this.len = words[0].length();
        this.wordCount = words.length;
        countMap = new HashMap<>();
        answer = new ArrayList<>();

        for (String w : words) {
            countMap.put(w, countMap.getOrDefault(w, 0) + 1);
        }
        for (int start = 0; start < len; start++) { // 시작점 - len개 이상은 inner loop에서 처리
            Map<String, Integer> window = new HashMap<>();
            int left = start;
            int count = 0;

            for (int right = start; right + len <= sentence.length(); right += len) {
                String word = s.substring(right, right + len);
                if (countMap.containsKey(word)) {
                    window.merge(word, 1, Integer::sum);
                    count++;
                    while (window.get(word) > countMap.get(word)) {
                        String leftWord = s.substring(left, left + len);
                        window.merge(leftWord, -1, Integer::sum);
                        left += len;
                        count--;
                    }
                    if (count == wordCount) {
                        answer.add(left);
                        String leftWord = s.substring(left, left + len);
                        window.merge(leftWord, -1, Integer::sum);
                        left += len;
                        count--;
                    }
                } else {
                    window.clear();
                    count = 0;
                    left = right + len;
                }
            }
        }
        return answer;
    }
}
