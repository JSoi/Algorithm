package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1062 {
    static final char[] essential = {'a', 'c', 'i', 'n', 't'};
    static int N, K;
    static int[] words;
    static boolean[] visited;
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (K < 5) {
            System.out.println(0);
            return;
        }

        words = new int[N];
        visited = new boolean[26];

        for (char c : essential) visited[c - 'a'] = true;

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            int mask = 0;
            for (char c : s.toCharArray()) {
                mask |= (1 << (c - 'a'));
            }
            words[i] = mask;
        }

        dfs(0, 0);
        System.out.println(answer);
    }

    private static void dfs(int idx, int count) {
        if (count == K - 5) {
            count();
            return;
        }
        if (idx >= 26) return;
        if (visited[idx]) {
            dfs(idx + 1, count);
            return;
        }
        visited[idx] = true;
        dfs(idx + 1, count + 1);

        visited[idx] = false;
        dfs(idx + 1, count);
    }

    private static void count() {
        int mask = 0;
        for (int i = 0; i < 26; i++)
            if (visited[i])
                mask |= (1 << i);

        int cnt = 0;
        for (int w : words) {
            if ((w & mask) == w)
                cnt++;
        }
        answer = Math.max(answer, cnt);
    }
}
