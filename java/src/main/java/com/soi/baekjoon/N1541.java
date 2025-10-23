package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split("-");
        int result = sum(tokens[0]);
        for (int i = 1; i < tokens.length; i++) {
            result -= sum(tokens[i]);
        }
        System.out.println(result);
    }

    private static int sum(String expr) {
        String[] nums = expr.split("\\+");
        int total = 0;
        for (String num : nums) {
            total += Integer.parseInt(num);
        }
        return total;
    }
}
