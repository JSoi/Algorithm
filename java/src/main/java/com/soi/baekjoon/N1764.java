package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class N1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String line = buf.readLine();
        int hear = Integer.parseInt(line.split(" ")[0]);
        int see = Integer.parseInt(line.split(" ")[1]);
        Set<String> hearSet = new HashSet<>();
        Set<String> seeSet = new HashSet<>();
        for (int i = 0; i < hear + see; i++) {
            String name = buf.readLine();
            if (i < hear) {
                hearSet.add(name);
            } else {
                seeSet.add(name);
            }
        }
        String[] result = hearSet.stream().filter(seeSet::contains).toArray(String[]::new);
        Arrays.sort(result);
        System.out.println(result.length);
        for (String r : result) {
            System.out.println(r);
        }
    }
}
