package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N1101 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int boxCount = Integer.parseInt(line[0]);
        int colorCount = Integer.parseInt(line[1]);

        HashMap<Integer, Set<Integer>> boxMap = new HashMap<>();
        HashMap<Integer, Set<Integer>> colorMap = new HashMap<>();
        for (int r = 0; r < boxCount; r++) {
            StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
            for (int c = 0; c < colorCount; c++) {
                int val = Integer.parseInt(tok.nextToken());
                if (val > 0) {
                    boxMap.computeIfAbsent(r, k -> new HashSet<>()).add(c);
                    colorMap.computeIfAbsent(c, k -> new HashSet<>()).add(r);
                }
            }
        }

        int answer = boxMap.size();

        // remove duplicates
        for (Map.Entry<Integer, Set<Integer>> c : colorMap.entrySet()) {
            int oneSizeBoxCount = (int) c.getValue().stream().filter(b -> boxMap.get(b).size() == 1).count();
            if (oneSizeBoxCount >= 1) {
                answer -= 1;
            }
        }
        System.out.println(Math.max(answer - 1, 0));
    }
}
