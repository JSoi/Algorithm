package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BOJ_1141 {
    public static void main(String[] args) throws IOException {
        List<String> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int lineCount = Integer.parseInt(br.readLine());
        while (lineCount-- > 0) {
            list.add(br.readLine());
        }
        int answer = 0;
        list = list.stream().sorted(Comparator.comparingInt(String::length)).distinct().collect(Collectors.toList());
        for (int i = 0; i < list.size(); i++) {
            String pre = list.get(i);
            boolean isPrefix = false;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).startsWith(pre)) {
                    isPrefix = true;
                    break;
                }
            }
            if (!isPrefix) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
