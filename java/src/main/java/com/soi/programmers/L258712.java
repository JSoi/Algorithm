package com.soi.programmers;

import java.util.HashMap;
import java.util.Map;

public class L258712 {
    public static void main(String[] args) {
//        String[] friends = new String[]{"muzi", "ryan", "frodo", "neo" };
//        String[] gifts = new String[]{"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi" };
//        String[] friends = new String[]{"joy", "brad", "alessandro", "conan", "david"};
//        String[] gifts = new String[]{"alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david" };
        String[] friends = new String[]{"a", "b", "c" };
        String[] gifts = new String[]{"a b", "b a", "c a", "a c", "a c", "c a" };
        int solution = new L258712().solution(friends, gifts);
        System.out.println(solution);
    }

    public int solution(String[] friends, String[] gifts) {
        int answer = 0;

        Map<String, Integer> giftPointMap = new HashMap<>();

        Map<String, Integer> nameToIndex = new HashMap<>();
        Map<Integer, String> indexToName = new HashMap<>();

        int friendIndex = 0;
        final int friendCount = friends.length;

        for (String friend : friends) {
            nameToIndex.put(friend, friendIndex);
            indexToName.put(friendIndex, friend);
            friendIndex++;
        }

        int[][] giveTakeArr = new int[friends.length][friends.length];

        for (String g : gifts) {
            String giver = g.split(" ")[0];
            String taker = g.split(" ")[1];
            giftPointMap.compute(giver, (k, v) -> v == null ? 1 : v + 1);
            giftPointMap.compute(taker, (k, v) -> v == null ? -1 : v - 1);
            giveTakeArr[nameToIndex.get(giver)][nameToIndex.get(taker)]++;
        }

        for (int g = 0; g < friendCount; g++) {
            int giverSum = 0;
            for (int t = 0; t < friendCount; t++) {
                if (giveTakeArr[g][t] > 0 && giveTakeArr[g][t] > giveTakeArr[t][g]) {
                    giverSum++;
                } else if (giveTakeArr[g][t] == giveTakeArr[t][g]) {
                    int giverPoint = giftPointMap.getOrDefault(indexToName.get(g),0);
                    int takerPoint = giftPointMap.getOrDefault(indexToName.get(t),0);
                    if (giverPoint > takerPoint) {
                        giverSum++;
                    }
                }
            }
            answer = Math.max(answer, giverSum);
        }
        return answer;
    }
}
