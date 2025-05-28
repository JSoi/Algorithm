package com.soi.programmers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.IntStream;

public class L150370 {
    public static void main(String[] args) {
        int[] solution = new L150370().solution("2022.05.19", new String[]{"A 6", "B 12", "C 3" }, new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C" });
        System.out.println(Arrays.toString(solution));
    }

    public int[] solution(String todayStr, String[] terms, String[] privacies) {
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        final LocalDate today = LocalDate.parse(todayStr, formatter);
        HashMap<String, Integer> expireDateMap = new HashMap<>();
        for (String t : terms) {
            expireDateMap.put(t.split(" ")[0], Integer.parseInt(t.split(" ")[1]));
        }
        return IntStream.range(1, privacies.length + 1).filter(i -> {
                    String privacyType = privacies[i - 1].split(" ")[1];
                    LocalDate collectDate = LocalDate.parse(privacies[i - 1].split(" ")[0], formatter);
                    return !today.isBefore(collectDate.plusMonths(expireDateMap.get(privacyType)));
                }
        ).toArray();
    }
}
