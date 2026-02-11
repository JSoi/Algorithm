package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class BOJ_2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
        int[] answer = new int[n];
        Stack<Tower> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(tok.nextToken());
            while (!stack.isEmpty() && stack.peek().height < input) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                answer[i] = stack.peek().idx;
            }
            stack.push(new Tower(i + 1, input));

        }
        System.out.println(Arrays.stream(answer).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
    }

    private static class Tower {
        int idx;
        int height;

        public Tower(int idx, int height) {
            this.idx = idx;
            this.height = height;
        }
    }
}
