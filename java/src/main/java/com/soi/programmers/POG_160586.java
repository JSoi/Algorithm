package com.soi.programmers;

import java.util.Arrays;

/**
 * @See <a href="https://school.programmers.co.kr/learn/courses/30/lessons/160586">대충 만든 자판</a>
 */
public class POG_160586 {
    int[] minCount = new int['Z' - 'A' + 1];

    public static void main(String[] args) {
        L160586 solution = new POG_160586();
        String[] keymap = {"ABACD", "BCEFD"};
        String[] targets = {"ABCD", "AABB"};
        System.out.println(Arrays.toString(solution.solution(keymap, targets)));
    }

    public int[] solution(String[] keymap, String[] targets) {
        Arrays.fill(minCount, Integer.MAX_VALUE);
        for (String key : keymap) {
            for (int i = 0; i < key.length(); i++) {
                if (minCount[key.charAt(i) - 'A'] > i + 1) {
                    minCount[key.charAt(i) - 'A'] = i + 1;
                }
            }
        }
        return Arrays.stream(targets).mapToInt(this::getCount).toArray();
    }

    public int getCount(String targetStr) {
        int count = 0;
        for (int i = 0; i < targetStr.length(); i++) {
            if (minCount[targetStr.charAt(i) - 'A'] == Integer.MAX_VALUE)
                return -1;
            count += minCount[targetStr.charAt(i) - 'A'];
        }
        return count;
    }

}
