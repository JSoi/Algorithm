package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1260_2 {
    static int N, M, start;
    static int[][] map;
    static boolean[] bfsv;
    static boolean[] dfsv;
    static StringBuffer bufd = new StringBuffer();
    static StringBuffer bufb = new StringBuffer();

    static void input() throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String line = buf.readLine();
        N = Integer.parseInt(line.split(" ")[0]);
        M = Integer.parseInt(line.split(" ")[1]);
        start = Integer.parseInt(line.split(" ")[2]);
        map = new int[N + 1][N + 1];
        dfsv = new boolean[N + 1];
        bfsv = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            String miniLine = buf.readLine();
            int a = Integer.parseInt(miniLine.split(" ")[0]);
            int b = Integer.parseInt(miniLine.split(" ")[1]);
            map[a][b] = map[b][a] = 1;
        } // read&fill
        dfs(start);
        bfs(start);
        System.out.println(bufd.toString());
        System.out.println(bufb.toString());
    }

    static void dfs(int now) { // stack/recursion
        dfsv[now] = true;
        bufd.append(now + " ");
        for (int i = 1; i <= N; i++) {
            if (!dfsv[i] && map[now][i] != 0) {
                dfs(i);
            }
        }
    }

    static void bfs(int now) { // queue
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(now);
        bfsv[now] = true;
        bufb.append(now + " ");
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int j = 1; j <= N; j++) {
                if (map[node][j] != 0 && !bfsv[j]) {
                    bfsv[j] = true;
                    queue.offer(j);
                    bufb.append(j + " ");
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        input();
    }

}
