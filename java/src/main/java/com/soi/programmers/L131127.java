package com.soi.programmers;

import com.soi.tool.Assertions;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class L131127 {
    public static void main(String[] args) throws Exception {
        int solution = new L131127().solution(new String[]{"banana", "apple", "rice", "pork", "pot"}, new int[]{3, 2, 2, 2, 1}, new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"});
        int solution2 = new L131127().solution(new String[]{"apple"}, new int[]{10}, new String[]{"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"});
        Assertions.check(solution, 3);
        Assertions.check(solution2, 0);
    }

    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        final Map<String, Integer> userMap =
                IntStream.range(0, want.length).boxed()
                        .collect(Collectors.toMap(i -> want[i], i -> number[i]));
        for (int i = 0; i <= discount.length - 10; i++) {
            Map<String, Integer> marketMap =
                    Arrays.stream(discount, i, i + 10)
                            .collect(Collectors.groupingBy(s -> s, Collectors.summingInt(s -> 1)));
            if (checkMap(marketMap, userMap)) {
                answer++;
            }
        }
        return answer;
    }

    private boolean checkMap(Map<String, Integer> marketMap, Map<String, Integer> userMap) {
        if (!marketMap.keySet().containsAll(userMap.keySet())) {
            return false;
        }
        for (Map.Entry<String, Integer> userProduct : userMap.entrySet()) {
            if (marketMap.get(userProduct.getKey()) < userProduct.getValue()) {
                return false;
            }
        }
        return true;
    }
}
