package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<Integer> cards = new HashSet<>();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer tok = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cards.add(Integer.parseInt(tok.nextToken()));
        }
        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        tok = new StringTokenizer(br.readLine());
        for (int j = 0; j < m; j++) {
            if (cards.contains(Integer.parseInt(tok.nextToken()))) {
                sb.append('1');
            } else {
                sb.append('0');
            }
            sb.append(' ');
        }
        System.out.println(sb);

    }
}
