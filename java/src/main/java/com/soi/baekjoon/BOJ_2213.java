package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2213 {
    private static int[] arr;
    private static int n;
    private static List<Integer>[] conn;
    private static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        conn = new List[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            conn[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            conn[u].add(v);
            conn[v].add(u);
        }
        int answer = 0;
        System.out.println(answer);
    }

    private static int dfs(int curr, boolean isVisit) {
        visit = new boolean[n + 1];
        boolean[] isOn = new boolean[n + 1];
        Stack<int[]> stack = new Stack<>();
        visit[curr] = true;
        isOn[curr] = isVisit;
        stack.push(new int[]{0, curr, isVisit ? arr[curr] : 0});

        while (!stack.isEmpty()) {
            int[] current = stack.pop(); // [prev, curr, cost]
            int cost = current[2];
            for (int next : conn[current[1]]) {
                if (visit[next]) continue;

            }

        }
        // 기록
        return 0;
    }
}
