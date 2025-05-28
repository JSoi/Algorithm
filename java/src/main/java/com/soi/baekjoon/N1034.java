package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N1034 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int row = Integer.parseInt(split[0]);
        int col = Integer.parseInt(split[1]);

        List<String> lamps = new ArrayList<>();
        Map<String, Integer> patternCount = new HashMap<>();

        for (int i = 0; i < row; i++) {
            String line = br.readLine();
            lamps.add(line);
            patternCount.put(line, patternCount.getOrDefault(line, 0) + 1);
        }
        int k = Integer.parseInt(br.readLine());
        int answer = 0;
        for (String pattern : patternCount.keySet()) {
            int offCount = countZeros(pattern);
            // 꺼진 개수가 K 이하이고, (K - 꺼진 수)가 짝수
            if (offCount <= k && (k - offCount) % 2 == 0) {
                answer = Math.max(answer, patternCount.get(pattern));
            }
        }
        System.out.println(answer);
    }

    private static int countZeros(String s) {
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '0') count++;
        }
        return count;
    }
}
