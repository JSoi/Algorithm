package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17299 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[n];
        int[] count = new int[1_000_001];
        int[] answer = new int[n];
        Arrays.fill(answer, -1);
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(tok.nextToken());
            count[arr[i]]++;
        }
        ArrayDeque<Integer> stacks = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            if (!stacks.isEmpty() && count[stacks.peek()] <= count[arr[i]]) {
                while (!stacks.isEmpty() && count[stacks.peek()] <= count[arr[i]]) {
                    stacks.pop();
                }
            }
            if (!stacks.isEmpty()) {
                answer[i] = stacks.peek();
            }
            stacks.push(arr[i]);
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            builder.append(answer[i]).append(" ");
        }
        System.out.println(builder);
    }
}
