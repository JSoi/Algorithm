package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class BOJ_1766 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(tok.nextToken());
        int M = Integer.parseInt(tok.nextToken());

        Set<Integer>[] conn = new Set[N];

        for (int i = 0; i < N; i++) {
            conn[i] = new HashSet<>();
        }

        int[] beforeCount = new int[N];

        for (int i = 0; i < M; i++) {
            tok = new StringTokenizer(br.readLine(), " ");
            // a -> b
            int a = Integer.parseInt(tok.nextToken()) - 1;
            int b = Integer.parseInt(tok.nextToken()) - 1;
            conn[a].add(b);
            beforeCount[b]++;
        }

        Queue<Integer> queue = new PriorityQueue<>();
        // init before count 0 nodes

        ArrayList<Integer> answer = new ArrayList<>(N);

        for (int i = 0; i < N; i++) {
            if (beforeCount[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            answer.add(curr);
            for (int next : conn[curr]) {
                beforeCount[next]--;
                if (beforeCount[next] == 0) {
                    queue.offer(next);
                }
            }

        }
        System.out.println(answer.stream().map(i -> String.valueOf(i + 1)).collect(Collectors.joining(" ")));
    }
}
