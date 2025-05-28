package com.soi.programmers;

import java.util.*;

public class L67258 {
    public static void main(String[] args) {
        int[] solution = new L67258().solution(new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"});
        System.out.println("solution = " + Arrays.toString(solution));
    }

    public int[] solution(String[] gems) {
        Map<String, Integer> countMap = new HashMap<>();
        int totalCount = (int) Arrays.stream(gems).distinct().count();
        int start = 0;
        int end = 0;
        int minLen = Integer.MAX_VALUE;
        int[] answer = new int[2];
        while (end < gems.length) {
            countMap.put(gems[end], countMap.getOrDefault(gems[end], 0) + 1);
            while (countMap.size() == totalCount) {
                if (end - start + 1 < minLen) {
                    minLen = end - start + 1;
                    answer[0] = start + 1;
                    answer[1] = end + 1;
                }
                int strValue = countMap.getOrDefault(gems[start], 0);
                if (strValue > 1) {
                    countMap.put(gems[start], strValue - 1);
                } else {
                    countMap.remove(gems[start]);
                }
                start++;
            }
            end++;
        }
        return answer;
    }
}
