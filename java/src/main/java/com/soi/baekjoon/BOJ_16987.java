package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ_16987 {
    private static int n, answer;
    private static int[] durability;
    private static int[] weight;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        durability = new int[n];
        weight = new int[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            durability[i] = Integer.parseInt(st.nextToken());
            weight[i] = Integer.parseInt(st.nextToken());
        }
        breakEgg(0, 0);
        System.out.println(answer);
    }

    private static void breakEgg(int current, int count) {
        answer = Math.max(answer, count);
        if (current == n) {
            return;
        }
        if (durability[current] <= 0) {
            breakEgg(current + 1, count);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (i == current || durability[i] <= 0) {
                continue;
            }
            int breakEggCount = 0;
            durability[current] -= weight[i];
            durability[i] -= weight[current];
            if (durability[current] <= 0) breakEggCount++;
            if (durability[i] <= 0) breakEggCount++;
            int nextCount = count + breakEggCount;
            breakEgg(current + 1, nextCount);
            durability[current] += weight[i];
            durability[i] += weight[current];
        }
    }
}
