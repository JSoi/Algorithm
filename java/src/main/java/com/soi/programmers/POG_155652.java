package com.soi.programmers;

import java.util.HashMap;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/155652">둘만의 암호</a>
 */
public class POG_155652 {
    public static void main(String[] args) {
        POG_155652 L155652 = new POG_155652();
        System.out.println(L155652.solution("aukks", "wbqd", 5));
    }

    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
        HashMap<Character, Integer> cMap = new HashMap<>();
        char[] indexCharArr = new char['z' - 'a' + 1 - skip.length()];
        int mapIndex = 0;
        for (int i = 0; i < 'z' - 'a' + 1; i++) {
            if (skip.indexOf((char) ('a' + i)) == -1) {
                cMap.put((char) ('a' + i), mapIndex);
                indexCharArr[mapIndex] = (char) ('a' + i);
                mapIndex++;
            }
        }
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            int changedIndex = (cMap.get(c) + index) % cMap.size();
            answer.append(indexCharArr[changedIndex]);
        }
        return answer.toString();
    }
}
