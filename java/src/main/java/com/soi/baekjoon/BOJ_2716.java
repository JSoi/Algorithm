package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2716 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (testCase-- > 0) {
            String input = br.readLine();
            int answer = (int) Math.pow(2, depth(input));
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }

    static int depth(String input) {
        int maxDepth = 0;
        int depth = 0;
        for (char c : input.toCharArray()) {
            if (c == '[') {
                depth++;
                maxDepth = Math.max(maxDepth, depth);
            } else {
                depth--;
            }
        }
        return maxDepth;
    }
}
