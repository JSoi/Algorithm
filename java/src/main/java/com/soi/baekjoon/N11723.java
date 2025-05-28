package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class N11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        int caseCount = Integer.parseInt(buf.readLine());
        Set<Integer> set = new HashSet<>();
        Set<Integer> initSet = IntStream.range(1, 21).boxed().collect(Collectors.toCollection(HashSet::new));
        StringBuffer sb = new StringBuffer();
        while (caseCount > 0) {
            caseCount--;
            String line = buf.readLine();
            String[] parseLine = line.split(" ");
            Integer num = parseLine.length == 1 ? 1 : Integer.parseInt(parseLine[1]);
            String command = parseLine[0];
            switch (command) {
                case "check" -> sb.append(set.contains(num) ? 1 : 0).append("\n");
                case "toggle" -> {
                    if (set.contains(num)) {
                        set.remove(num);
                    } else {
                        set.add(num);
                    }
                }
                case "remove" -> set.remove(num);
                case "add" -> set.add(num);
                case "all" -> {
                    set.clear();
                    set.addAll(initSet);
                }
                case "empty" -> set.clear();
                default -> throw new IllegalArgumentException();
            }
//            System.out.println(set);
        }
        System.out.print(sb);
    }
}
