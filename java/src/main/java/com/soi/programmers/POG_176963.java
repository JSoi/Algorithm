package com.soi.programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/176963">추억 점수</a>
 */
public class POG_176963 {
    public static void main(String[] args) {
        L176963 l176963 = new POG_176963();
        int[] solution = l176963.solution(new String[]{"may", "kein", "kain", "radi"}, new int[]{5, 10, 1, 3}, new String[][]{{"may", "kein", "kain", "radi"}, {"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}});
//        System.out.println(("[[\"may\", \"kein\", \"kain\", \"radi\"],[\"may\", \"kein\", \"brin\", \"deny\"], [\"kon\", \"kain\", \"may\", \"coni\"]]")
//                .replaceAll("\\[", "\\{").replaceAll("\\]", "\\}"));
        System.out.println(Arrays.toString(solution));

    }

    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        HashMap<String, Integer> collect =
                IntStream.range(0, name.length).boxed()
                        .collect(Collectors.toMap(key -> name[key], value -> yearning[value], (a, b) -> a, HashMap::new));
        return Arrays.stream(photo)
                .mapToInt(p -> Arrays.stream(p).mapToInt(s -> collect.getOrDefault(s, 0)).sum()).toArray();
    }
}
