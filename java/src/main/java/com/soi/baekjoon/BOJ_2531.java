package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_2531 {
    private static final Map<Integer, Integer> countMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(tok.nextToken());
        int D = Integer.parseInt(tok.nextToken());
        int K = Integer.parseInt(tok.nextToken());
        int C = Integer.parseInt(tok.nextToken());
        int[] table = new int[N + K];
        for (int i = 0; i < N; i++) {
            table[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < K; i++) {
            table[i + N] = table[i];
        }
        // initial
        for (int i = 0; i < K; i++) {
            add(table[i]);
        }
        int answer = count(C);
        for (int i = 1; i < N; i++) {
            remove(table[i - 1]);
            add(table[i + K - 1]);
            answer = Math.max(answer, count(C));
//            System.out.println(answer);
        }
        System.out.println(answer);
    }

    private static void add(int sushi) {
        countMap.put(sushi, countMap.getOrDefault(sushi, 0) + 1);
    }

    private static void remove(int sushi) {
        int cc = countMap.get(sushi);
        if (cc == 1) {
            countMap.remove(sushi);
        } else {
            countMap.put(sushi, cc - 1);
        }
    }


    private static int count(int coupon) {
        return countMap.size() + (!countMap.containsKey(coupon) ? 1 : 0);
    }

}
