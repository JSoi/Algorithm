package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BOJ_1967 {
    static List<int[]>[] connection;
    static int longestStart;
    static int longestDistance;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        connection = new List[n];
        for (int i = 0; i < n; i++) {
            connection[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            String[] input = br.readLine().split(" ");
            int parent = Integer.parseInt(input[0]) - 1;
            int child = Integer.parseInt(input[1]) - 1;
            int weight = Integer.parseInt(input[2]);
            connection[parent].add(new int[]{child, weight});
            connection[child].add(new int[]{parent, weight});
        }
        longestStart = 0;
        longestDistance = 0;
        visited = new boolean[n];
        dfs();
        longestDistance = 0;
        visited = new boolean[n];
        dfs();
        System.out.println(longestDistance);

    }

    private static void dfs() {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{longestStart, longestDistance});
        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            visited[current[0]] = true;
            if (current[1] > longestDistance) {
                longestDistance = current[1];
                longestStart = current[0];
            }
            for (int[] next : connection[current[0]]) {
                if (visited[next[0]]) continue;
                stack.push(new int[]{next[0], current[1] + next[1]});
            }
        }
    }
}
