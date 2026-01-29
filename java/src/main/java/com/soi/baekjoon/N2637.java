package com.soi.baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * <a href= "https://www.acmicpc.net/problem/2637">장난감 조립</a>
 */
public class N2637 {
    private static List<int[]>[] nextConnections;
    private static boolean[] visited;
    private static int[][] countConn;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];
        countConn = new int[n + 1][n + 1];
        nextConnections = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            nextConnections[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            nextConnections[x].add(new int[]{y, k});
        }
        dp(n);
//        System.out.println(Arrays.deepToString(countConn));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i <= n; i++) {
            if (countConn[n][i] == 0) {
                continue;
            }
            bw.write(i + " " + countConn[n][i] + "\n");
        }
        bw.flush();
    }

    private static void dp(int index) {
        // 필요한 leaf를 업데이트하는 과정
        if (visited[index]) {
            return;
        }
        visited[index] = true;
        if (nextConnections[index].isEmpty()) { // leaf 처리
            countConn[index][index] = 1;
            return;
        }
        // 바로 leaf로 향해 연산 횟수 줄이도록 수정
        for (int[] nn : nextConnections[index]) {
            int nextIdx = nn[0];
            int nextCnt = nn[1];
            dp(nextIdx);
            for (int i = 1; i <= n; i++) {
                countConn[index][i] += countConn[nextIdx][i] * nextCnt;
            }
        }
    }
}
