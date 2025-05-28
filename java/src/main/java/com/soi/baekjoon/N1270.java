package com.soi.baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class N1270 {

    public static final String NON = "SYJKGW";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int landCount = Integer.parseInt(br.readLine());
        for (int l = 0; l < landCount; l++) {
            long[] warriors = Arrays.stream(br.readLine().split(" ")).skip(1).mapToLong(Long::parseLong).toArray();
            long answer = getDominantArmy(warriors);
            if (answer == -1) {
                bw.write(NON + "\n");
            } else {
                bw.write(answer + "\n");
            }
        }
        bw.flush();
    }

    public static long getDominantArmy(long[] warriors) {
        HashMap<Long, Integer> map = Arrays.stream(warriors).boxed()
                .collect(Collectors.toMap(key -> key, value -> 1, Integer::sum, HashMap::new));
        for (Map.Entry<Long, Integer> e : map.entrySet()) {
            if (e.getValue() > warriors.length / 2) {
                return e.getKey();
            }
        }
        return -1;
    }
}
