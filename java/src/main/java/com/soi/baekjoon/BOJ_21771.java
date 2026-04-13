package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_21771 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");

        int pRCount = Integer.parseInt(st.nextToken());
        int pCCount = Integer.parseInt(st.nextToken());

        char[][] map = new char[r][c];
        int pCount = 0;
        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = line.charAt(j);
                if (line.charAt(j) == 'P') {
                    pCount++;
                }
            }
        }
        if (pCount < pRCount * pCCount) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
