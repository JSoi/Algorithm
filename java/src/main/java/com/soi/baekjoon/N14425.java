package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class N14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(tok.nextToken());
        int M = Integer.parseInt(tok.nextToken());
        HashSet<String> strings = new HashSet<>();
        for (int i = 0; i < N; i++) {
            strings.add(br.readLine());
        }
        int answer = 0;
        for (int i = 0; i < M; i++) {
            if (strings.contains(br.readLine())) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
