package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N18352 {
    public static final int MAX = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken()) - 1;
        List<Integer>[] conn = new List[N];
        for (int i = 0; i < N; i++) {
            conn[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            conn[a].add(b);
        }
        int[] dist = new int[N]; // x 로부터의 거리
        boolean[] visit = new boolean[N]; // 방문 여부
        Arrays.fill(dist, MAX);
//        for (List<Integer> c : conn) {
//            System.out.println(c);
//        }
        dist[X] = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{X, 0});
        visit[X] = true;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int c : conn[curr[0]]) {
                if (visit[c]) {
                    continue;
                }
                visit[c] = true;
                dist[c] = curr[1] + 1;
                queue.offer(new int[]{c, curr[1] + 1});
            }
        }
//        System.out.println(Arrays.toString(dist));
//        for (int[] c : conn) {
//            System.out.println(Arrays.toString(c));
//        }
        StringBuilder answerSb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (dist[i] == K) {
                answerSb.append(i + 1).append("\n");
            }
        }
        System.out.println(answerSb.isEmpty() ? "-1" : answerSb.toString());
    }
}
