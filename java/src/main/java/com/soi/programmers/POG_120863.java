package com.soi.programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class POG_120863 {
    public static void main(String[] args) {
        System.out.println(new POG_120863().solution("3x + 7 + x"));
        System.out.println(new POG_120863().solution("3xx + 7 + x"));
        System.out.println(new POG_120863().solution("x + x + x"));
    }

    public String solution(String polynomial) {
        String[] polyArr = polynomial.split(" \\+ ");
        int xSum = 0;
        int constant = 0;
        Map<String, Integer> polyMap = new HashMap<>();

        for (String p : polyArr) {
            if (p.endsWith("x")) {
                int xStart = p.indexOf('x');
                String x = p.substring(xStart);
                int count = x.length() == p.length() ? 1 : Integer.parseInt(p.substring(0, xStart));
                polyMap.put(x, polyMap.getOrDefault(x, 0) + count);
            } else {
                constant += Integer.parseInt(p);
            }
        }
        ArrayList<String> result = polyMap.entrySet().stream()
                .sorted((e1, e2) -> e2.getKey().length() - e1.getKey().length())
                .map(e -> (e.getValue() == 1 ? "" : e.getValue()) + e.getKey())
                .collect(Collectors.toCollection(ArrayList::new));
        if (constant != 0) {
            result.add(String.valueOf(constant));
        }
        return String.join(" + ", result);
    }
}
