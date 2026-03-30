package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_17207 {
    private static final String[] name = {"Inseo", "Junsuk", "Jungwoo", "Jinwoo", "Youngki"};

    public static void main(String[] args) throws IOException {
        int[][] a = new int[5][5];
        int[][] b = new int[5][5];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 5; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 5; j++) {
                b[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        ArrayList<int[]> result = new ArrayList<>();
        for (int me = 0; me < 5; me++) {
            int totalThroughPut = 0;
            for (int work = 0; work < 5; work++) {
                for (int i = 0; i < 5; i++) {
                    totalThroughPut += a[me][i] * b[i][work];
                }
            }
            result.add(new int[]{me, totalThroughPut});
        }
        result.sort((r1, r2) -> r1[1] == r2[1] ? r2[0] - r1[0] : r1[1] - r2[1]);
        System.out.println(name[result.get(0)[0]]);
    }
}
