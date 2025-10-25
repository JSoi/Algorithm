package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class N10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> mine = new HashMap<>();
        StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(tok.nextToken());
            mine.put(val, mine.getOrDefault(val, 0) + 1);

        }
        int m = Integer.parseInt(br.readLine());

        int[] cards = new int[m];

        tok = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {
            cards[i] = Integer.parseInt(tok.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for (int card : cards) {
            sb.append(mine.getOrDefault(card, 0)).append(" ");
        }

        System.out.print(sb);
    }
}
