package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N2623 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(tok.nextToken());
        int M = Integer.parseInt(tok.nextToken());
        int[] beforeCount = new int[N];
        List<Integer>[] conn = new List[N];
        for (int i = 0; i < N; i++) {
            conn[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            tok = new StringTokenizer(br.readLine(), " ");
            int K = Integer.parseInt(tok.nextToken());
            int before = Integer.parseInt(tok.nextToken()) - 1;
            for (int j = 0; j < K - 1; j++) {
                int next = Integer.parseInt(tok.nextToken()) - 1;
                beforeCount[next]++;
                conn[before].add(next);
                before = next;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> answer = new ArrayList<>();

        // init
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

        for (int i = 0; i < N; i++) {
            if (beforeCount[i] > 0) {
                System.out.println(0);
                return;
            }
        }
        answer.stream().map(i -> i + 1).forEach(System.out::println);
    }
}
