package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class N1302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        int max = 0;
        while (count-- > 0) {
            String key = br.readLine();
            int value = map.getOrDefault(key, 0) + 1;
            map.put(key, value);
            max = Math.max(max, value);
        }
        int finalMax = max;
        map.entrySet().stream().filter(e -> e.getValue() == finalMax)
                .sorted((e1, e2) -> e1.getValue().equals(e2.getValue()) ? e1.getKey().compareTo(e2.getKey()) : e1.getValue() - e2.getValue())
                .limit(1)
                .forEach(e -> System.out.println(e.getKey()));
    }
}
