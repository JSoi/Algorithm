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
    private static int[] necessaryCounts;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        necessaryCounts = new int[n + 1];
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
        dp(n, 1);
//        System.out.println(Arrays.toString(necessaryCounts));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i <= n; i++) {
            if (necessaryCounts[i] == 0) {
                continue;
            }
            bw.write(i + " " + necessaryCounts[i] + "\n");
        }
        bw.flush();
    }

    private static void dp(int componentIdx, int count) {
        if (nextConnections[componentIdx].isEmpty()) {
            necessaryCounts[componentIdx] += count;
            return;
        }
        for (int[] nn : nextConnections[componentIdx]) {
            int nextIdx = nn[0];
            int nextCount = nn[1];
            dp(nextIdx, count * nextCount);
        }
    }
}
