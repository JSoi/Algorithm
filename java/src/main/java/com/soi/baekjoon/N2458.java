package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N2458 {
    private static int N;
    private static int[] smaller;
    private static int[] larger;
    private static List<Integer>[] conn;

    public static void main(String[] args) throws IOException {
        init();
        for (int i = 0; i < N; i++) {
            travel(i);
        }
//        System.out.println(Arrays.toString(smaller));
//        System.out.println(Arrays.toString(larger));
        int answer = 0;
        for (int i = 0; i < N; i++) {
            if (smaller[i] + larger[i] == N - 1) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    private static void travel(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        boolean[] visit = new boolean[N];
        visit[start] = true;
        while (!queue.isEmpty()) {
            int latest = queue.poll();
            for (int l : conn[latest]) {
                if (visit[l]) {
                    continue;
                }
                visit[l] = true;
                queue.offer(l);
                larger[start]++;
                smaller[l]++;
            }
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        smaller = new int[N];
        larger = new int[N];
        conn = new List[N];
        for (int i = 0; i < N; i++) {
            conn[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            conn[a].add(b); // 단반향  a<b
        }
//        System.out.println(Arrays.deepToString(conn));
    }
}
