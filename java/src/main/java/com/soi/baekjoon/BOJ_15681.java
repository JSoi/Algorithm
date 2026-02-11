package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_15681 {
    static boolean[] visit;
    static int[] ans;
    static ArrayList<Integer>[] conn;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        conn = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            conn[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            conn[u].add(v);
            conn[v].add(u);
        }
        visit = new boolean[N + 1];
        ans = new int[N + 1];
        count(R);

        for (int i = 0; i < Q; i++) {
            bw.write(count(Integer.parseInt(br.readLine())) + "\n");
        }
        bw.flush();
    }


    static int count(int r) {
        visit[r] = true;
        for (int i : conn[r]) {
            if (!visit[i]) {
                ans[r] += count(i);
            }
        }
        return ans[r] + 1;
    }
}
