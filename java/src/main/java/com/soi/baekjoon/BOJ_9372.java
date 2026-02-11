package com.soi.baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_9372 {
    static int answer;
    static boolean[] visit;
    static int cityCount;
    static Map<Integer, Set<Integer>> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        map = new HashMap<>();
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            answer = 0;
            String[] line = br.readLine().split(" ");
            cityCount = Integer.parseInt(line[0]);
            int roadCount = Integer.parseInt(line[1]);
            visit = new boolean[cityCount + 1];
            map = new HashMap<>();
            for (int j = 0; j < roadCount; j++) {
                String[] input = br.readLine().split(" ");
                int a = Integer.parseInt(input[0]);
                int b = Integer.parseInt(input[1]);
                map.computeIfAbsent(a, v -> new HashSet<>()).add(b);
                map.computeIfAbsent(b, v -> new HashSet<>()).add(a);
            }
            travel();
            bw.append(String.valueOf(answer - 1)).append("\n");
        }
        bw.flush();

    }

    static void travel() {
        Queue<Integer> edges = new LinkedList<>();
        visit[1] = true;
        edges.offer(1);
        while (!edges.isEmpty()) {
            answer++;
            int e = edges.poll();
            for (int n : map.get(e)) {
                if (visit[n]) {
                    continue;
                }
                visit[n] = true;
                edges.offer(n);
            }
        }
    }
}
