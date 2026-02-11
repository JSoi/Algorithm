package com.soi.programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/258709">주사위 고르기</a>
 */
public class POG_258709 {
    static int[] answer;
    static int winCount = 0;
    static int[][] dice;
    static int pickCount;

    public static int[] solution(int[][] diceInput) {
        dice = diceInput;
        pickCount = dice.length / 2;
        answer = new int[pickCount];
        for (int[] d : dice) {
            Arrays.sort(d);
        }
        roll(new boolean[dice.length], 0, pickCount);
        return answer;
    }

    static void roll(boolean[] visit, int index, int count) {
//        System.out.println("visit = " + Arrays.toString(visit) + " | index = " + index + " | count = " + count);
        if (count == 0) {
            Map<Integer, Integer> pickedMap = getConjMap(IntStream.range(0, dice.length)
                    .filter(j -> visit[j])
                    .boxed()
                    .collect(Collectors.toSet()));
            Map<Integer, Integer> unpickedMap = getConjMap(IntStream.range(0, dice.length)
                    .filter(j -> !visit[j])
                    .boxed()
                    .collect(Collectors.toSet()));
            int localWinCount = 0;
            for (Map.Entry<Integer, Integer> pickedEntry : pickedMap.entrySet()) {
                for (Map.Entry<Integer, Integer> unpickedEntry : unpickedMap.entrySet()) {
                    if (pickedEntry.getKey() > unpickedEntry.getKey()) {
                        localWinCount += pickedEntry.getValue() * unpickedEntry.getValue();
                    }
                }
            }
            if (localWinCount > winCount) {
//                System.out.println("localWinCount = " + localWinCount + " | " + visit + " " + Arrays.toString(visit));
                answer = IntStream.range(0, visit.length)
                        .filter(v -> visit[v]).map(i -> i + 1).toArray();
                winCount = localWinCount;
            }
            return;
        }
        for (int j = index; j < dice.length; j++) {
            if (visit[j]) continue;
            visit[j] = true;
            roll(visit, j, count - 1);
            visit[j] = false;
        }

    }

    static Map<Integer, Integer> getConjMap(Set<Integer> visitIndex) {
        Map<Integer, Integer> resultMap = new HashMap<>();
        int[][] diceList = visitIndex.stream().map(j -> dice[j]).toArray(int[][]::new);
        for (int[] d : diceList) {
            Map<Integer, Integer> diceMap = Arrays.stream(d).boxed()
                    .collect(Collectors.toMap(key -> key, value -> 1, Integer::sum, HashMap::new));
            resultMap = hapMap(resultMap, diceMap);
        }
        return resultMap;
    }

    static Map<Integer, Integer> hapMap(Map<Integer, Integer> fMap, Map<Integer, Integer> sMap) {
        Map<Integer, Integer> resultMap = new HashMap<>();
        if (fMap.isEmpty()) {
            return sMap;
        }
        for (Map.Entry<Integer, Integer> fEtry : fMap.entrySet()) {
            for (Map.Entry<Integer, Integer> sEtry : sMap.entrySet()) {
                resultMap.put(fEtry.getKey() + sEtry.getKey(),
                        resultMap.getOrDefault(fEtry.getKey() + sEtry.getKey(), 0) + fEtry.getValue() * sEtry.getValue());
            }
        }
        return resultMap;
    }

    public static void main(String[] args) {
        int[][] input = {{1, 2, 3, 4, 5, 6}, {3, 3, 3, 3, 4, 4}, {1, 3, 3, 4, 4, 4}, {1, 1, 4, 4, 5, 5}};
        System.out.println(Arrays.toString(solution(input)));
    }
}
