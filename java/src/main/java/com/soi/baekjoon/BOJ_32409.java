package com.soi.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_32409 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {
            int n = Integer.parseInt(br.readLine());
            long[] arr = new long[n]; // 합이 클 수 있으므로 long 권장
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(st.nextToken());
            }
            bw.append(canSolve(arr, n) ? "YES" : "NO").append("\n");
        }
        bw.flush();
    }
    private static boolean canSolve(long[] a, int n) {
        if (n == 1) {
            return a[0] == 1;
        }
        long edge = 2L * a[0] - 1; // 간선 수
        for (int i = 1; i < n - 1; i++) {
            long currentEdge = 2L * a[i];
            edge = currentEdge - edge; // 남은 간선 수로 업데이트
            if (edge < 1) return false;
        }
        long lastEdge = 2L * a[n - 1];
        return edge == lastEdge - 1 || edge == lastEdge + 1;
    }
}
