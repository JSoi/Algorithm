package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1009 {
    static int[][] chart = new int[10][4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer buf = new StringBuffer();
        int testCase = Integer.parseInt(br.readLine());
        StringTokenizer tok;

        chart[0] = new int[]{0, 0, 0, 0};
        chart[1] = new int[]{1, 1, 1, 1};
        chart[2] = new int[]{6, 2, 4, 8};
        chart[3] = new int[]{1, 3, 9, 7};
        chart[4] = new int[]{6, 4, 6, 4};
        chart[5] = new int[]{5, 5, 5, 5};
        chart[6] = new int[]{6, 6, 6, 6};
        chart[7] = new int[]{1, 7, 9, 3};
        chart[8] = new int[]{6, 8, 4, 2};
        chart[9] = new int[]{1, 9, 1, 9};

        for (int i = 0; i < testCase; i++) {
            tok = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(tok.nextToken());
            int b = Integer.parseInt(tok.nextToken());
            int val = findVal(a, b);
            buf.append((val == 0 ? 10 : val) + "\n");
        }
        System.out.println(buf);
    }

    static int findVal(int a, int b) {
        int newA = a % 10;
        int newB = b % 4;
        return chart[newA][newB];
    }

    static int findValPow(int a, int b) {
        int ans = 1;
        for (int i = 0; i < b; i++) {
            ans *= a;
            ans %= 10;
        }
        return ans;
    }
}
