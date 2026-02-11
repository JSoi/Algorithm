package com.soi.programmers;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class POG_42579 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"classic", "pop", "classic", "classic", "pop"},
                new int[]{500, 600, 150, 800, 2500})));
    }

    public static int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genreCount =
                IntStream.range(0, genres.length).boxed()
                        .collect(Collectors.toMap(i -> genres[i], i -> plays[i], Integer::sum));
        Map<String, List<int[]>> genreMusics = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            genreMusics.computeIfAbsent(genres[i], g -> new ArrayList<>()).add(new int[]{i, plays[i]});
        }
        return genreCount.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue() - e1.getValue())
                .flatMap(e -> genreMusics.get(e.getKey()).stream().sorted((a, b) -> b[1] - a[1]).map(a -> a[0]).limit(2))
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
