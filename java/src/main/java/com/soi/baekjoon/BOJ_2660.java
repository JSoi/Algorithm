package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class BOJ_2660 {
    private static final int MAX = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] conn = new int[n][n];
        for (int[] c : conn) {
            Arrays.fill(c, MAX);
        }
        String line;

        while (!(line = br.readLine()).equals("-1 -1")) {
            int a = Integer.parseInt(line.split(" ")[0]) - 1;
            int b = Integer.parseInt(line.split(" ")[1]) - 1;
            conn[a][b] = conn[b][a] = 1;
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (conn[i][k] != MAX && conn[k][j] != MAX) {
                        conn[i][j] = Math.min(conn[i][j], conn[i][k] + conn[k][j]);
                    }
                }
            }
        }
//        System.out.println(Arrays.deepToString(conn));
        int min = MAX;
        ArrayList<Integer> candidates = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n && conn[i][j] != MAX; j++) {
                if (i == j) continue;
                count = Math.max(count, conn[i][j]);
            }
            if (count < min) {
                min = count;
                candidates.clear();
                candidates.add(i + 1);
            } else if (count == min) {
                candidates.add(i + 1);
            }
        }
        System.out.println(min + " " + candidates.size());
        System.out.println(candidates.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}
