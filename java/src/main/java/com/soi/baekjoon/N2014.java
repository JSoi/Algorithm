package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N2014 {
    private static int N, K;
    private static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
        K = Integer.parseInt(tok.nextToken());
        N = Integer.parseInt(tok.nextToken());
        tok = new StringTokenizer(br.readLine(), " ");
        arr = new long[K];
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(tok.nextToken());
        }
        Arrays.sort(arr);
        System.out.println(findNum());
    }

    private static long findNum() {
        Queue<Long> queue = new PriorityQueue<>();
        for (int i = 0; i < K; i++) {
            queue.add(arr[i]);
        }
        HashSet<Long> visit = new HashSet<>();
        int count = 0;
        while (!queue.isEmpty()) {
            long curr = queue.poll();
            if (visit.contains(curr)) {
                continue;
            }
            visit.add(curr);
            count++;
//            System.out.println(curr + " " + count);
            if (count == N) {
                return curr;
            }
            for (int i = 0; i < K; i++) {
                queue.add(arr[i] * curr);
            }
        }
        return 0;
    }
}
