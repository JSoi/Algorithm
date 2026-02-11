package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_14267 {
    private static List<Integer>[] conn;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        int[] root = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        conn = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            conn[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            conn[root[i]].add(i + 1);
        }
        int m = Integer.parseInt(st.nextToken());
        HashMap<Integer, Integer> complimentMap = new HashMap<>();
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            complimentMap.put(a, complimentMap.getOrDefault(a, 0) + b);
        }
        int[] answer = new int[n + 1];
        for (Map.Entry<Integer, Integer> e : complimentMap.entrySet()) {
            int parent = e.getKey();
            int compliment = e.getValue();
            boolean[] v = new boolean[n + 1];
            Stack<Integer> stack = new Stack<>();
            stack.push(parent);
            v[parent] = true;
            while (!stack.isEmpty()) {
                int curr = stack.pop();
                answer[curr] += compliment;
                for (int next : conn[curr]) {
                    if (v[next]) {
                        continue;
                    }
                    v[next] = true;
                    stack.push(next);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb);
    }

}
