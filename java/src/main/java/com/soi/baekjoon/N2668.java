package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class N2668 {
    private static int[] arr;
    private static int n;
    private static boolean[] isAnswer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n + 1];
        isAnswer = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
        }
        for (int i = 1; i <= n; i++) {
            dfs(i);
        }
        List<Integer> answer = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (isAnswer[i]) {
                answer.add(i);
            }
        }
        System.out.println(answer.size());
        answer.forEach(System.out::println);
    }

    private static void dfs(int idx) {
        boolean[] visited = new boolean[n + 1];
        Stack<Integer> stack = new Stack<>();
        boolean[] keys = new boolean[n + 1];
        boolean[] values = new boolean[n + 1];
        stack.push(idx);
        visited[idx] = keys[idx] = values[arr[idx]] = true;
        while (!stack.isEmpty()) {
            int key = stack.pop();
            keys[key] = values[arr[key]] = true;
            int value = arr[key];
            if (visited[value]) continue;
            stack.push(value);
            values[value] = visited[key] = true;
        }
        for (int i = 1; i <= n; i++) {
            if ((keys[i] && !values[i]) || (!keys[i] && values[i])) {
                return;
            }
        }
        for (int i = 1; i <= n; i++) {
            if (keys[i]) isAnswer[i] = true;
        }
    }
}
